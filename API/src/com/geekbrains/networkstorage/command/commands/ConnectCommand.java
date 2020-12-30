package com.geekbrains.networkstorage.command.commands;

import com.geekbrains.networkstorage.command.datas.CommandData;
import com.geekbrains.networkstorage.command.metas.CommandMeta;
import com.geekbrains.networkstorage.command.metas.ConnectMeta;

public class ConnectCommand extends Command{
    private CommandMeta meta;

    public ConnectCommand(CommandMeta meta) {
        this.meta = meta;
    }

    public ConnectCommand(String[] params){
        meta = new ConnectMeta(params[1], params[2]);
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
        return null;
    }
}
