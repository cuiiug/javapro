package  cn.hui.javapro.bio;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class  TimeServerHandler implements Runnable{

    private Socket socket;

    public TimeServerHandler(Socket socket){
        this.socket = socket;
    }

	public void run() {
        BufferedReader in = null;
        PrintWriter out = null;

        List<String> list = new ArrayList<String>();
        list.add("dd");
	}


}