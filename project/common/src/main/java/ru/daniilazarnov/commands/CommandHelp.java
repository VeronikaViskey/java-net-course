package ru.daniilazarnov.commands;

import ru.daniilazarnov.Commands;
import ru.daniilazarnov.FileLoaded;
import ru.daniilazarnov.FileWorker;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.Map;

public class CommandHelp implements Command {


    @Override
    public void send(ChannelHandlerContext ctx, String content, FileWorker fileWorker, byte signal) {
        System.out.println(Commands.help());
    }

    @Override
    public void response(ChannelHandlerContext ctx, ByteBuf buf, FileWorker fileWorker, Map<Integer,
            FileLoaded> uploadedFiles, byte signal) {

    }

    @Override
    public void receive(ChannelHandlerContext ctx, ByteBuf buf, FileWorker fileWorker, Map<Integer,
            FileLoaded> uploadedFiles) {

    }
}
