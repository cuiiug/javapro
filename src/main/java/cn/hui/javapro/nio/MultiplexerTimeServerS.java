package cn.hui.javapro.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

//NIO时间服务器
public class MultiplexerTimeServerS implements Runnable {

	private Selector selector;

	private ServerSocketChannel servChannel;

	private volatile boolean stop;

	/**
	 * 初始化多路复用器，绑定监听端口
	 */
	public MultiplexerTimeServerS(int port) {
		try {
			// 创建多路复用器selector，ServerSocketChannel
			selector = Selector.open();
			servChannel = ServerSocketChannel.open();
			servChannel.configureBlocking(false);
			servChannel.socket().bind(new InetSocketAddress(port), 1024);
			// 将ServerSocketChannel 注册到 Selector，监听SelectionKey.OP_ACCEPT操作位
			servChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The time server is start in port:" + port);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void stop() {
		this.stop = stop;
	}

	// run方法的while循环体中遍历selector
	public void run() {
		while (!stop) {
			try {
				// 它的休眠时间为1s,间隔1s被唤醒
				selector.select(1000);
				// 当有处于就绪状态的Channel时，selector将返回该Channel的SelectionKey集合。
				// 通过对就绪状态的Channel集合进行迭代，可以进行网络的异步读写操作
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectionKeys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
					it.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						e.printStackTrace();
						if (key != null) {
							key.cancel();
							if (key.channel() != null) {
								key.channel().close();

							}
						}
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 多路服务器关闭后，所有注册在上面的Channel和Pipe等资源都会自动去注册并关闭，所以不需要重复释放资源
		if (selector != null) {
			try {
				selector.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void handleInput(SelectionKey key) throws IOException {
		if (key.isValid()) {
			// 处理新接入的请求信息
			// 根据SelectionKey的操作位进行判断即可知网络事件的类型
			if (key.isAcceptable()) {
				// accept the new connection
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				// 通过ServerSocketChannel的accept接收客户端的链接请求并创建SocketChannel实例
				// 完成上述操作后，相当于完成了TCP三次握手，TCP物理链路正式建立
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				// add the new connection to the selector
				sc.register(selector, SelectionKey.OP_READ);
			}
			if (key.isReadable()) {
				// read the data
				SocketChannel sc = (SocketChannel) key.channel();
				// 开辟一个1M的缓冲区
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				// 调用SocketChannel的read方法读取请求码流
				// 此时read是非阻塞的
				int readBytes = sc.read(readBuffer);
				// >0 读到字节
				// =0 没有读到字节
				// =-1 链路已经关闭，需要关闭SocketChannel，释放资源
				if (readBytes > 0) {
					// flip方法：将缓冲区当前的limit设置为position，position设置为0
					// 用于后续对缓存区的读取操作
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes, "utf-8");
					System.out.println("The time server receive order:" + body);
					String currentTime = "query time order".equalsIgnoreCase(body)
							? new Date(System.currentTimeMillis()).toString()
							: "bad order";
					doWrite(sc, currentTime);
				} else if (readBytes < 0) {
					// 对端链路关闭
					key.cancel();
					sc.close();
				} else {
					System.out.println("读到0字节");
				}
			}
		}
	}

	// 将应答消息异步发送给客户端
	public void doWrite(SocketChannel channel, String response) throws IOException {
		if (response != null && response.trim().length() > 0) {
			// 首先将字符串编码成字节数组
			byte[] bytes = response.getBytes();
			// 创建ByteBuffer
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer);
		}
	}

}
