package com.geekbrains.networkstorage.commands;

import com.geekbrains.networkstorage.Encodable;
import com.geekbrains.networkstorage.data.CommandData;
import com.geekbrains.networkstorage.meta.CommandMeta;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;


public abstract class Command implements Encodable {
    public abstract CommandMeta getMeta();

    public abstract CommandData getData();

    @Override
    public ByteBuf encode(){

        ByteBuf buf = Unpooled.buffer();

        ByteBuf meta = getMeta().encode();
        int metaLength = meta.readableBytes();

        buf.writeInt(metaLength);
        buf.writeBytes(meta);

        ByteBuf data = getData().encode();
        long dataLength = data.readableBytes();

        buf.writeLong(dataLength);
        buf.writeBytes(data);

        return buf;
    }
}
