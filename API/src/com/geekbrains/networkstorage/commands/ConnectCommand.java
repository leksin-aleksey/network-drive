package com.geekbrains.networkstorage.commands;

import com.geekbrains.networkstorage.data.CommandData;
import com.geekbrains.networkstorage.data.ConnectData;
import com.geekbrains.networkstorage.meta.CommandMeta;
import com.geekbrains.networkstorage.meta.ConnectMeta;


public class ConnectCommand extends Command{
    private CommandMeta meta;
    private CommandData data;

    public ConnectCommand(CommandMeta meta) {
        this.meta = meta;
    }

    public ConnectCommand(String[] params){
        meta = new ConnectMeta(params[1], params[2]);
        data = new ConnectData();
    }

    public ConnectCommand(String username, String password){
        meta = new ConnectMeta(username, password);
    }

    @Override
    public CommandMeta getMeta() {
        return meta;
    }

    @Override
    public CommandData getData() {
        return data;
    }
}
