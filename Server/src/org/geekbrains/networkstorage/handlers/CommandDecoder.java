package org.geekbrains.networkstorage.handlers;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.geekbrains.networkstorage.command.Command;

public class CommandDecoder extends SimpleChannelInboundHandler<Command> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Command command) throws Exception {
        if (command.decoderResult().isSuccess()){
            /* TODO */
        }
    }
}
