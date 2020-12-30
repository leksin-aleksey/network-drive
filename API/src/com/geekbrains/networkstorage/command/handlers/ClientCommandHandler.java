package com.geekbrains.networkstorage.command.handlers;

import com.geekbrains.networkstorage.command.commands.Command;
import com.geekbrains.networkstorage.command.commands.CommandFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class ClientCommandHandler extends MessageToByteEncoder<String> {
    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf out) throws Exception {
        Command command = CommandFactory.parseCommand(msg);
        out.writeBytes(command.commandEncode());
        System.out.println("writing bytes");
//        out.writeInt(4);
//        out.writeBytes("test".getBytes());
        ctx.flush();
    }
}
