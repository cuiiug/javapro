package cn.hui.javapro.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import java.io.UnsupportedEncodingException;

public class TimeClientHandler extends ChannelHandlerAdapter {
    private final ByteBuf firstMessage;

    public TimeClientHandler() {
        byte[] req = "query_time order".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(firstMessage);
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "utf-8");
        System.out.println("now is :" + body);
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        //释放资源
        ctx.close();
    }
}