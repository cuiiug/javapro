package cn.hui.javapro.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	public static void main(String[] args) {
		int portNumber = 8080;
		try {
			// 创建一个新的ServerSocket，用以监听指定端口上的链接请求
			ServerSocket serverSocket = new ServerSocket(portNumber);
			// 对accept()方法的调用将被阻塞，直到一个链接建立
			Socket clientSocket = serverSocket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			String request, response;
			// readLine() 将会阻塞，直到一个由换行符或者回车符结尾的字符串被读取
			while ((request = in.readLine()) != null) {
				if ("Done".equals(request)) {
					break;
				}
				response = processRequest(request);
				// 服务器的响应，发送给客户端
				out.println(response);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String processRequest(String request) {
		return "";
	}
}
