package com.geekbrains.networkstorage.data;


import com.geekbrains.networkstorage.Encodable;
import io.netty.buffer.ByteBuf;

public abstract class CommandData implements Encodable {
    @Override
    public abstract ByteBuf encode();
}
