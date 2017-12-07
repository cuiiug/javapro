package cn.hui.javapro.nio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class IODemo {

    public static void main(String[] args) {
        readFileByFileInputStream();
    }

    /**
     * 采用FileInputStream读取文件内容
     */
    public static void readFileByFileInputStream() {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("src/main/java/cn/hui/javapro/nio/nio.md"));
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    //中文乱码
                    System.out.println((char) buf[i]);
                }
                bytesRead = in.read(buf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(in != null){
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}