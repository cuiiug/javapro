package cn.hui.javapro.nio;

public class TimeClientS{

    public static void main(String[] args) {
        int port = 8080;

        new Thread(new TimeClientHandlerS("127.0.0.1",port),"TimeClient-001").start();
    }
}