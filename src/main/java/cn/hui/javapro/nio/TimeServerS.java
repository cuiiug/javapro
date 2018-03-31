package cn.hui.javapro.nio;

public class TimeServerS{
    public static void main(String[] args) {
        int port = 8080;   
        MultiplexerTimeServerS timeServer = new MultiplexerTimeServerS(port);
        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();

    }
}