package com.geekbrains.networkstorage.handlers;

import com.geekbrains.networkstorage.commands.Command;
import com.geekbrains.networkstorage.commands.CommandFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class ClientCommandHandler extends MessageToByteEncoder<String> {
    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf out) throws Exception {
        Command command = CommandFactory.parseCommand(msg);
        out.writeBytes(command.encode());
        ctx.flush();
    }
}
