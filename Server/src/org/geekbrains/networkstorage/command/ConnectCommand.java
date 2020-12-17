package org.geekbrains.networkstorage.command;

import org.apache.commons.cli.Options;

public class ConnectCommand implements Command{
    private Options options;

    public ConnectCommand(Options options) {
        this.options = options;
    }

    @Override
    public void run() {
        /* TODO */
    }
}
