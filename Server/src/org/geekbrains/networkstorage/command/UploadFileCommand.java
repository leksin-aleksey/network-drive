package org.geekbrains.networkstorage.command;

import io.netty.handler.codec.DecoderResult;
import org.apache.commons.cli.Options;

public class UploadFileCommand implements Command{
    private Options options;

    public UploadFileCommand(Options options) {
        this.options = options;
    }

    public void run() {
        /* TODO */
    }

    @Override
    public DecoderResult decoderResult() {
        return null;
    }

    @Override
    public void setDecoderResult(DecoderResult result) {

    }
}
