package cn.hui.javapro.zookeeper.na;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.KeeperState;

public class ZookeeperUsage implements Watcher {

    private static final String HOST_ADDRESS ="10.200.91.118:2181";
 
    private static CountDownLatch connectedCountDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        connectBySID_PWD();
      
    }

    /**
     * 创建节点
     */
    

    /**
     * 保存name、pwd
     */
    public static void connectBySID_PWD(){
        try {
            ZooKeeper zk = new ZooKeeper(HOST_ADDRESS,500,new ZookeeperUsage());
            connectedCountDownLatch.await();
            //获取sid、pwd
            long sessionId = zk.getSessionId();
            byte[] passwd = zk.getSessionPasswd();
            //用错误的sid、pwd连接
            zk = new ZooKeeper(HOST_ADDRESS,5000,new ZookeeperUsage(),1l,"test".getBytes());
            //用正确的SID、PWD
            zk = new ZooKeeper(HOST_ADDRESS,5000,new ZookeeperUsage(),sessionId,passwd);
            Thread.sleep(Integer.MAX_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public static void connectOne(){
        try {
            ZooKeeper zookeeper = new ZooKeeper(HOST_ADDRESS, 5000, new ZookeeperUsage());
            connectedCountDownLatch.await();
            System.out.println("状态建立完毕----");
            System.out.println(zookeeper.getState());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void process(WatchedEvent event) {
        System.out.println("Receive watched event:" + event);
        if (KeeperState.SyncConnected == event.getState()) {
            connectedCountDownLatch.countDown();
        }
    }

}