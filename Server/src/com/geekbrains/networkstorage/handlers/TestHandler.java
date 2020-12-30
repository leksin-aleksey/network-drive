package com.geekbrains.networkstorage.handlers;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class TestHandler extends ByteToMessageDecoder {
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client connected");
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println(in.toString());
        int metaLength = -1;
        String meta;
//        long dataLength = -1;
//        byte[] data;

        if (in.readableBytes() >= 4){
            metaLength = in.readInt();
            System.out.println(metaLength);
        }
        if (in.readableBytes() >= metaLength){
            meta = in.readCharSequence(metaLength, StandardCharsets.UTF_8).toString();
            System.out.println(meta);
        }
//        ctx.fireChannelReadComplete();


//        if (in.readableBytes() >= 8){
//            dataLength = in.readInt();
//            System.out.println(dataLength);
//        }
//        data = new byte[dataLength];
//        if (in.readableBytes() >= dataLength){
//            for (int i = 0; i < dataLength; i++) {
//                da
//            }
//        }
    }
}
