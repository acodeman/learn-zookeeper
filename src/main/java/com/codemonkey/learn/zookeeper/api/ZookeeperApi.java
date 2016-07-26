package com.codemonkey.learn.zookeeper.api;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import com.alibaba.fastjson.JSON;
/**
 * 测试
 * @author 
 *
 */
public class ZookeeperApi {

	public static void main(String[] args) throws IOException, KeeperException,
			InterruptedException {
		ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 2000, new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				System.out.println("event :" + JSON.toJSONString(event));
			}
			
		});
		String root = "/testRootPath";
		zk.create(root, "testRootData".getBytes(),
				Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println(zk.getData(root, true, null));
//		zk.setData(root, "就知道".getBytes(), -1);
//		zk.delete(root, -1);
		zk.create(root + "/testChildPathOne", "testRootData".getBytes(),
				Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//		zk.delete(root + "/testChildPathOne", -1);
//		System.out.println(zk.getChildren(root, true));
		zk.close();
	}

}
