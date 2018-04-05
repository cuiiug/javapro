package cn.hui.javapro.netty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class OldNet {

	public static void main(String[] args) throws IOException {
		int portNumber = 8080;
		// 创建一个新的ServerSocket，用以监听指定端口上的链接请求
		ServerSocket serverSocket = new ServerSocket(portNumber);
		// 对accept方法的调用将被阻塞，直到链接建立
		Socket clientSocket = serverSocket.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		String request, response;
		while ((request = in.readLine()) != null) {
			if ("Done".equals(request)) {
				break;
			}
			response = request;
			out.println(response);
		}
		if (serverSocket != null) {
			serverSocket.close();
		}
	}
}
