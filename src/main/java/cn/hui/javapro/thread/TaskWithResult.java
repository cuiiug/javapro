package cn.hui.javapro.thread;

import java.util.concurrent.Callable;

/**
 * 实现Callable 接口，接收返回值
 */
public class TaskWithResult implements Callable{
    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }

	@Override
	public Object call() throws Exception {
		return "result of taskWithResult " + id;
	}

}