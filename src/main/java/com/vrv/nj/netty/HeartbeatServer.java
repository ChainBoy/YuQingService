package com.vrv.nj.netty;

import com.vrv.nj.common.Constants;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * 服务端
 *  
 * @author  赵炎
 * @version  [V1.00, 2016年10月18日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class HeartbeatServer
{
    static final int PORT = Constants.LISTEN_PORT;
    
    public static void main(String[] args)
        throws Exception
    {
        // Configure the server.
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try
        {
            // 配置netty程序，串联起各个组件
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 100)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new HeartBeatHandlerInitializer());
            // Start the server.
            ChannelFuture f = b.bind(PORT).sync();
            // Wait until the server socket is closed.
            f.channel().closeFuture().sync();
        }
        finally
        {
            // Shut down all event loops to terminate all threads.
            // 正常关闭
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
