package com.geekbrains.networkstorage.command.commands;

import com.geekbrains.networkstorage.command.datas.CommandData;
import com.geekbrains.networkstorage.command.metas.CommandMeta;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;


public abstract class Command {
    public abstract CommandMeta getMeta();

    public abstract CommandData getData();

    public ByteBuf commandEncode(){

        ByteBuf buf = Unpooled.buffer();

        byte[] meta = getMeta().encodeMeta();
        int metaLength = meta.length;
//        buf.writeInt(metaLength);
//        buf.writeBytes(meta);
//
//        int dataLength;
//        byte[] dataEncoded;
//        CommandData data = getData();
//        if (data == null){
//            dataEncoded = null;
//            dataLength = 0;
//        } else {
//            dataEncoded = data.encodeData();
//            dataLength = dataEncoded.length;
//        }
//
//        System.out.println(metaLength);
//        System.out.println(meta.length);
//        System.out.println(dataLength);
//        System.out.println("dataEncoded");

//        buf.writeInt(dataLength);
//        buf.writeBytes(dataEncoded);

        buf.writeInt(metaLength);
        buf.writeBytes(meta);
//        buf.writeBytes("connect t1 l1".getBytes());

        return buf;
    }
}
