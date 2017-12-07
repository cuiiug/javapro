package cn.hui.javapro.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIODemo {

    public static void readFileByNIO() {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("src/main/java/cn/hui/javapro/nio/nio.md", "rw");
            FileChannel fileChannel = aFile.getChannel();
            //分配空间
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //写入到buffer
            int bytesRead = fileChannel.read(buf);
            while (bytesRead != -1) {
                //调用flip方法
                buf.flip();
                while(buf.hasRemaining()){
                    //从buffer中读取数据
                    System.out.println((char)buf.get());
                }
                //调用clear方法或compact方法
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(aFile != null){
                    aFile.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}