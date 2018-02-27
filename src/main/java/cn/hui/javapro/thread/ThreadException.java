package cn.hui.javapro.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadException implements Runnable{

    @Override
    public void run(){
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            exec.execute(new ThreadException());
        } catch (Exception e) {
            //TODO: handle exception
        }

    }
}