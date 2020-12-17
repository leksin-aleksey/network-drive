package org.geekbrains.networkstorage.command;

import org.apache.commons.cli.Options;

public class CommandFactory {
    private CommandFactory(){}

    public static Command getCommand(String commandName, Options options){
        switch (commandName){
            case "connect":
                return new ConnectCommand(options);
            case "upload":
                return new UploadFileCommand(options);
            default:
                throw new IllegalArgumentException(commandName);
        }
    }
}
