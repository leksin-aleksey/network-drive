package com.geekbrains.networkstorage.command.metas;


public abstract class CommandMeta {
    public abstract String getCommandName();

    public abstract byte[] encodeMeta();
}
