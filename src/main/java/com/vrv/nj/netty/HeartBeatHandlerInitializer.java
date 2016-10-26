package com.vrv.nj.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * ChannelInitializer 配置handler
 * 提供一个ChannelPipeline，并把handler加入到ChannelPipeline
 * 一个Netty应用基于ChannelPipeline机制，
 * 这种机制需要依赖于EventLoop（处理io操作）和EventLoopGroup（包含多个EventLoop）
 * Channel 代表一个socket链接，或者其它和IO操作相关的组件，它和EventLoop一起用来参与IO处理。 
 * @author  赵炎
 * @version  [V1.00, 2016年10月17日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class HeartBeatHandlerInitializer extends ChannelInitializer<SocketChannel>
{
    private static final int READ_IDEL_TIME_OUT = 1; // 读超时
    
    private static final int WRITE_IDEL_TIME_OUT = 2;// 写超时
    
    private static final int ALL_IDEL_TIME_OUT = 3; // 所有超时
    
    @Override
    protected void initChannel(SocketChannel channel)
        throws Exception
    {
        ChannelPipeline pipeline = channel.pipeline();
        // step 1
        pipeline.addLast(new IdleStateHandler(READ_IDEL_TIME_OUT, WRITE_IDEL_TIME_OUT, ALL_IDEL_TIME_OUT, TimeUnit.SECONDS));
        // step 2
        pipeline.addLast(new HeartBeatServerHandler());
    }
    
}
