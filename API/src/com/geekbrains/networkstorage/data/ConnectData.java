package com.geekbrains.networkstorage.data;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ConnectData extends CommandData{
    @Override
    public ByteBuf encode() {
        return Unpooled.EMPTY_BUFFER;
    }
}
