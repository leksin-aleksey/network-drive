package com.geekbrains.networkstorage;

import io.netty.buffer.ByteBuf;

public interface Encodable {
    ByteBuf encode();
}
