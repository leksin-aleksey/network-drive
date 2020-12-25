package org.geekbrains.networkstorage.handlers;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;
import org.geekbrains.networkstorage.server.Server;
import org.geekbrains.networkstorage.user.UserAuth;

import java.util.List;

public class AuthDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("AuthDecoder");

        Boolean isAuth = ctx.channel().attr(Server.AUTH).get();
        if (isAuth == null || !isAuth.equals(Boolean.TRUE)) {
//            String auth = in.toString(CharsetUtil.UTF_8);
            String auth = in.readCharSequence(in.readableBytes(), CharsetUtil.UTF_8).toString();
            String login = auth.split("\\s")[0];
            String password = auth.split("\\s")[1];
//            in.release();
            out.add(new UserAuth(login, password));
        } else {
            ctx.fireChannelReadComplete();
        }
    }
}
