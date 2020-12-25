package org.geekbrains.networkstorage.handlers;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.geekbrains.networkstorage.server.Server;


public class UserAuthHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("*UserAuthHandler");
        System.out.println("Client connected");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("*UserAuthHandler");
        Boolean isAuth = ctx.channel().attr(Server.AUTH).get();
        if (isAuth == null || !isAuth.equals(Boolean.TRUE)) {
            /* TODO login User */
            System.out.println(msg);
            ctx.channel().attr(Server.AUTH).set(Boolean.TRUE);
            ctx.fireChannelReadComplete();
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
