#nio desc

1、NIO主要有三大部分：Channel、Buffer、Selector
2、传统IO基于字节流、字符流进行操作，而NIO基于Channel、Buffer进行操作
   数据总是从通道读到缓冲区或是从缓冲区写到通道
3、NIO和IO的第一个区别：NIO是面向缓冲区的，IO是面向流的
4、IO是阻塞的，当一个线程调用read()或write()时，该线程被阻塞
5、NIO是非租塞的

#Channel
1、Channel 是双向的，即可用来读操作，也可以用来写操作
2、NIO中的Channel主要实现：FileChannel、DatagramChannel、SocketChannel、ServerSocketChannel，分别对应文件IO、UDP和TCP（Server和Client）

#Buffer
1、NIO中Buffer实现有：ByteBuffer、CharBuffer、DoubleBuffer、FloatBuffer、IntBuffer、LongBuffer、ShortBuffer等

#Selector
1、Selector运行单线程，处理多个Channel，如果应用打开多个Channel，每个Channel流量都很低，使用Selector很方便。

#desc
1、buffer：缓冲区，实际上是一个容器，一个连续数组。Channel提供从文件、网络读取数据的渠道，但读写的数据都必须经过buffer
           client----->Buffer------>Channel------Channel------->Buffer-------->Server
2、向Buffer中写数据：
   从Channel写到Buffer
   通过Buffer的put方法
3、从Buffer读数据：
   从Buffer读取到Channel
   使用get方法从Buffer读取数据



#http://blog.csdn.net/u013256816/article/details/51457215