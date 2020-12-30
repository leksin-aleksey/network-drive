package com.geekbrains.networkstorage.command.commands;

public class CommandFactory {
    private CommandFactory() {
    }

    public static Command parseCommand(String str){
        String[] commandParams = str.split("\\s");

        switch (commandParams[0]) {
            case "connect":
                return new ConnectCommand(commandParams);
//            case "upload_file":
//                new UploadFileCommand(commandParams);
            default:
                throw new IllegalArgumentException(commandParams[0]);
        }
    }
}
