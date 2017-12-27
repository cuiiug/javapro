package cn.hui.javapro.thread;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Run {
    public static void main(String[] args) {
        callableRun();
    }

    /**
     * 有返回值的线程
     */
    public static void callableRun(){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for(int i = 0;i<5;i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for(Future f:results){
            try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
        }
    }

    /**
     * singleThreadExecutor 提交多个任务，将排队执行
     */
    public static void singleThreadExec(){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i = 0;i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
    /**
     * FixedThreadPool 使用有限的线程集来执行所提交的任务
     */
    public static void fixedExector(){
        ExecutorService  exec = Executors.newFixedThreadPool(5);
        for(int i = 0;i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
    /**
     * Executor java.util.concurrent包中的执行器，管理Thread对象
     * ExecutorService 具有服务生命周期的Executor，知道如何构建恰当的上下文来执行Runnable对象
     * shutdown() 方法防止新任务提交给Executor，当前线程将继续运行在shutdown()被调用之前提交的所有任务
     */
    public static void executorRun(){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0;i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }

}