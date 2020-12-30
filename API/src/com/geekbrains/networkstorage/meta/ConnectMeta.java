package com.geekbrains.networkstorage.meta;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Map;


public class ConnectMeta extends CommandMeta {

    private final String username;
    private final String password;

    public ConnectMeta(Map<String, String> creds) {
        this.username = creds.get("username");
        this.password = creds.get("password");
    }

    public ConnectMeta(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getCommandName() {
        return "connect";
    }

    @Override
    public ByteBuf encode() {
        ByteBuf buf = Unpooled.buffer();
        String metaEncoded = getCommandName() + " " + username + " " + password;
        buf.writeBytes(metaEncoded.getBytes());
        return buf;
    }
}
