package cn.hui.javapro.bio;

import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer{
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("the time server is start in port:"+port);
            Socket socket = null;
            while(true){
                socket = server.accept();
                new Thread()
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}