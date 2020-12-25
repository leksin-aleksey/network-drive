package org.geekbrains.networkstorage.command;

import io.netty.handler.codec.DecoderResult;
import org.apache.commons.cli.Options;

public class ConnectCommand implements Command{
    private Options options;

    public ConnectCommand(Options options) {
        this.options = options;
    }

//    @Override
//    public void run() {
//        /* TODO */
//    }


    @Override
    public DecoderResult decoderResult() {
        return null;
    }

    @Override
    public void setDecoderResult(DecoderResult result) {

    }
}
