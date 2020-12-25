package org.geekbrains.networkstorage.handlers;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.geekbrains.networkstorage.server.Server;
import org.geekbrains.networkstorage.user.User;
import org.geekbrains.networkstorage.user.UserAuth;

import java.util.Set;


public class UserAuthHandler extends SimpleChannelInboundHandler<UserAuth> {
    private final Set<User> connectedUsers;

    public UserAuthHandler(Set<User> connectedUsers) {
        this.connectedUsers = connectedUsers;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("*UserAuthHandler");
        System.out.println("Client connected");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, UserAuth msg) throws Exception {
        Boolean isAuth = ctx.channel().attr(Server.AUTH).get();

        if (isAuth == null || !isAuth.equals(Boolean.TRUE)) {

            User newUser = msg.authenticate();
            if (newUser != null) {
                System.out.println(msg.getLogin());
                ctx.channel().attr(Server.AUTH).set(Boolean.TRUE);
                connectedUsers.add(newUser);
            }
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
