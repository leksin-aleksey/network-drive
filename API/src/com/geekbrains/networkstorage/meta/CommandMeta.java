package com.geekbrains.networkstorage.meta;


import com.geekbrains.networkstorage.Encodable;
import io.netty.buffer.ByteBuf;

public abstract class CommandMeta implements Encodable {
    public abstract String getCommandName();

    @Override
    public abstract ByteBuf encode();
}
