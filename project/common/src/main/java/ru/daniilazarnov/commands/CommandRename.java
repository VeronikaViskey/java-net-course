package ru.daniilazarnov.commands;

import ru.daniilazarnov.BufWorker;
import ru.daniilazarnov.FileLoaded;
import ru.daniilazarnov.FileWorker;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;
import java.util.Map;

public class CommandRename implements Command {
    @Override
    public void send(ChannelHandlerContext ctx, String content, FileWorker fileWorker, byte signal) {
        String[] names = content.split("\\s");
        if (names.length == 2) {
            List<String> list = List.of(names);
            fileWorker.sendCommandWithStringList(ctx, list, signal);
        } else {
            System.out.println("Incorrect data entry");
        }
    }

    @Override
    public void response(ChannelHandlerContext ctx, ByteBuf buf, FileWorker fileWorker, Map<Integer,
            FileLoaded> uploadedFiles, byte signal) {
        List<String> list = BufWorker.readFileListFromBuf(buf);
        String fileName = list.get(0);
        String newFileName = list.get(1);
        fileWorker.renameFile(fileName, newFileName);
    }

    @Override
    public void receive(ChannelHandlerContext ctx, ByteBuf buf, FileWorker fileWorker, Map<Integer,
            FileLoaded> uploadedFiles) {

    }
}
