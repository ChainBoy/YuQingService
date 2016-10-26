package com.vrv.nj.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vrv.nj.common.Constants;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

/**
 * 心跳服务器处理器
 * ChannelInboundHandler 处理接收到数据时的事件
 * 即核心业务逻辑
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月17日]
 * @see [相关类/方法]
 * @since V1.00
 */
public class HeartBeatServerHandler extends ChannelInboundHandlerAdapter
{
    private static final Logger LOGGER = LoggerFactory.getLogger(HeartBeatServerHandler.class);
    // 1
    private static final ByteBuf HEARTBEAT_SEQUENCE = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer(Constants.HEART_BEAT_CN, CharsetUtil.UTF_8));
    
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
        throws Exception
    {
        if (evt instanceof IdleStateEvent)
        {
            // 2
            IdleStateEvent event = (IdleStateEvent)evt;
            String type = "";
            // 读空闲
            if (event.state() == IdleState.READER_IDLE)
            {
                type = "发送心跳";
            }
            // 写空闲
            else if (event.state() == IdleState.WRITER_IDLE)
            {
                type = "接收心跳";
            }
            else if (event.state() == IdleState.ALL_IDLE)
            {
                type = "all idle";
            }
            ctx.writeAndFlush(HEARTBEAT_SEQUENCE.duplicate()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE); // 3
            LOGGER.info("remote ip:{}===>>>{}...",ctx.channel().localAddress(),type);
        }
        else
        {
            super.userEventTriggered(ctx, evt);
        }
    }
}
