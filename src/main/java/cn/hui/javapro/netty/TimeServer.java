package cn.hui.javapro.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimeServer {

    public static void main(String[] args) {
        try {
            new TimeServer().bind(8080);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bind(int port) throws Exception {
        /**
            * NioEventLoopGroup：是个线程组，包含了一组NIO线程，专门用于网络事件的处理
            *                    实际上他们就是Reactor线程组。
            * 创建两个，一个用于服务端接收客户端的连接，一个用于进行SocketChannel的网络读写
            */
        //配置服务端的NIO线程
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            /**
             * ServerBootstrap Netty用于启动NIO服务端的服务启动类，目的是降低服务端的开发复杂度。
             */
            ServerBootstrap b = new ServerBootstrap();
            /**
             * group方法，将两个NIO线程组当作入参传递到ServerBootstrap中，接着设置创建的Channel为NioServerSocketChannel
             * ，功能对应于JDK NIO类库中的ServerSocketChannel类。
             * 然后配置NioServerSocketChannel的TCP参数
             * 最后绑定I/O事件的处理类ChildChannelHandler，用于处理网络I/O事件
             */
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelHandler());
            /**
             * 调用 同步阻塞 sync方法，等待绑定操作完成。
             * 返回一个ChannelFuture，主要用于异步的通知回调
             */
            //绑定端口，同步等待成功
            ChannelFuture f = b.bind(port).sync();
            // 等待服务端监听端口关闭
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        protected void initChannel(SocketChannel arg0) {
            arg0.pipeline().addLast(new TimeServerHandler());
        }

    }
}