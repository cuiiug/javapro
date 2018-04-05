#netty 
##netty是一款用于快速开发高性能的网络应用程序的java框架。它封装了网络编程的复杂性。

##选择器（java.nio.channels.Selector 是Java的非阻塞I/O实现的关键。使用了事件通知API以确定在一组非阻塞套接字中有哪些已经就绪能够进行I/O相关操作。


##核心组件
###Channel：是Java NIO的一个基本构造。可以看作传入或传出数据的载体。可以被打开或者关闭，链接或者断开。


###回调：其实就是一个方法，一个指向已经被提供给另一个方法的方法引用。可以使得被提供出去的方法在适当的时候被调用。Netty在内部使用回调处理事件；当一个回调被触发时，相关的事件可以被一个interface-channelHandler的实现处理。

###Future：提供了另一种在操作完成时通知应用程序的方式。这个可以看作是一个异步操作的结果占位符；它将在未来的某个时刻完成，并提供对其结果的访问。 netty提供了自己的实现channelFuture，用于异步执行操作的时候使用。
####channelFuture 提供的方法使得我们能够注册一个或者多个ChannelFutureListener实例。监听器的回调方法operationComplete()，将会在对应的操作完成时被调用。可以判断操作是完成还是出错。
####ChannelFutureListener提供的 通知机制消除了手动检查对应的操作是否完成的必要。每个Netty的出站I/O操作都返回一个channelFuture，不会阻塞。
#### 可以把ChannelFutureListener看作回调的一个更加精细的版本，事实上Future和回调是相互补充的机制；相互结合，构成了Netty本身的关键构建块之一。


###事件和ChannelHandler：Netty使用不同的事件来通知我们状态的改变或者操作的状态。每个事件都可以被分发给ChannelHandler类中的某个用户实现的方法。

