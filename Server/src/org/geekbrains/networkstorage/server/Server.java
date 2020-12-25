package org.geekbrains.networkstorage.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.AttributeKey;
import io.netty.util.CharsetUtil;
import org.geekbrains.networkstorage.handlers.CommandHandler;
import org.geekbrains.networkstorage.handlers.UserAuthHandler;

import java.util.Properties;

public class Server {
    public final static AttributeKey<Boolean> AUTH = AttributeKey.valueOf("auth");

    private final Properties SERVER_PROPERTIES;
    private final int PORT;

    public Server(){
        SERVER_PROPERTIES = ServerProperties.getServerProperties();
        PORT = Integer.parseInt(SERVER_PROPERTIES.getProperty("server.network.port"));

        try {
            start();
        } catch (InterruptedException e) {
            /* TODO log */
            e.printStackTrace();
        }
    }

    private void start() throws InterruptedException{
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 10)
//                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
                        p.addLast(new StringDecoder(CharsetUtil.UTF_8));
                        p.addLast(new StringEncoder(CharsetUtil.UTF_8));
                        p.addLast(new UserAuthHandler());
                        p.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
                        p.addLast(new StringDecoder(CharsetUtil.UTF_8));
                        p.addLast(new StringEncoder(CharsetUtil.UTF_8));
                        /* TODO add Pipeline ChannelHandlers*/
                        p.addLast(new CommandHandler());
                    }
                });
            ChannelFuture f = b.bind(PORT).sync();
            System.out.println("**Server's ready");
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
