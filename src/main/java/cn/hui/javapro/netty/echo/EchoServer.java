package cn.hui.javapro.netty.echo;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {

	private final int port;

	public EchoServer(int port) {
		this.port = port;
	}

	public static void main(String[] args) throws Exception {
		int port = 8080;
		new EchoServer(port).start();
	}

	public void start() throws Exception {
		final EchoServerHandler serverHandler = new EchoServerHandler();
		// 创建EventLoopGroup
		EventLoopGroup group = new NioEventLoopGroup();
		// 创建 ServerBootstrap
		try {
			ServerBootstrap b = new ServerBootstrap();
			// 指定所使用的NIO 传输Channel
			// 使用指定的端口设置套接字地址
			// 添加一个EchoServerHandler到子Channel的ChannelPipeline
			b.group(group).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(port))
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							// EchoServerHandler被标注为@Shareable，所以我们可以总是使用同样的实例
							ch.pipeline().addLast(serverHandler);
						}
					});
			// 异步绑定服务器,调用sync()方法阻塞，等待直到绑定完成
			ChannelFuture f = b.bind().sync();
			// 获取Channel的closeFuture，并且阻塞当前线程直到它完成
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭EventLoopGroup,释放所有资源
			group.shutdownGracefully().sync();
		}
	}

}
