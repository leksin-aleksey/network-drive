package com.geekbrains.networkstorage.command.metas;

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

//    public String getUsername() {
//        return username;
//    }


    @Override
    public String getCommandName() {
        return "connect";
    }

    @Override
    public byte[] encodeMeta() {
        String metaEncoded = getCommandName() + " " + username + " " + password;
        return metaEncoded.getBytes();
    }
}
