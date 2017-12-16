package cn.hui.javapro.zookeeper.na;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.KeeperState;

public class ZookeeperUsage  implements Watcher{

    private static CountDownLatch connectedCountDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
       
        try {
            ZooKeeper zookeeper = new ZooKeeper("192.168.1.8:2181",5000,new ZookeeperUsage());
            connectedCountDownLatch.await();
            System.out.println("状态建立完毕----");
            System.out.println(zookeeper.getState());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	@Override
	public void process(WatchedEvent event) {
        System.out.println("Receive watched event:"+event);
        if(KeeperState.SyncConnected == event.getState()){
            connectedCountDownLatch.countDown();
        }
	}

}