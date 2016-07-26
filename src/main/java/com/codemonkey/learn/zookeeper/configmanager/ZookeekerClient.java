package com.codemonkey.learn.zookeeper.configmanager;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;

import com.alibaba.fastjson.JSON;

public class ZookeekerClient {

	public final String configNode = "/config";

	public ZooKeeper zk;

	public ZookeekerClient(String url) {
		try {
			zk = new ZooKeeper(url, 2000, new Watcher() {
				// 监控所有被触发的事件
				public void process(WatchedEvent event) {
					System.out.println("event :" + JSON.toJSONString(event));
				}
			});
			if (zk.exists(configNode, false) == null) {
				zk.create(configNode, "init".getBytes(), Ids.OPEN_ACL_UNSAFE,
						CreateMode.PERSISTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateConfig(String content) {
		try {
			zk.setData(configNode, content.getBytes(), -1);
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
