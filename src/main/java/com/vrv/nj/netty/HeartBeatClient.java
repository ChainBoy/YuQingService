package com.vrv.nj.netty;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import com.vrv.nj.common.Constants;

/**
 * 客户端
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月17日]
 * @see [相关类/方法]
 * @since V1.00
 */
public class HeartBeatClient
{
    public static void main(String[] args)
    {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap().group(group).channel(NioSocketChannel.class).handler(new HeartBeatHandlerInitializer());
        try
        {
            Channel channel = bootstrap.connect(Constants.LISTEN_IP, Constants.LISTEN_PORT).sync().channel();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while (true)
            {
                channel.writeAndFlush(in.readLine());
            }
        }
        catch (Exception e)
        {
        }
        finally
        {
            group.shutdownGracefully();
        }
        
    }
}
