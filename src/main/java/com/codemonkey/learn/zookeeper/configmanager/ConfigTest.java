package com.codemonkey.learn.zookeeper.configmanager;

 
public class ConfigTest {
 
 
    public static void main(String args[]){
        ConfigManager cfgManager = new ConfigManager();
        String data = "一个真是的配置";
        cfgManager.updateToDB(data);
        
        ZookeekerClient ser = new ZookeekerClient("127.0.0.1:2181");
        ZookeekerClient c = new ZookeekerClient("127.0.0.1:2182");
        ser.updateConfig(data);
        
        String data1 = "一个真是的配置3333";
        cfgManager.updateToDB(data1);
        ser.updateConfig(data1);
    }
 
 
}