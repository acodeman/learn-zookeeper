package com.codemonkey.learn.zookeeper.configmanager;
import java.io.Serializable;

/**
 */
public class ConfigContent implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 端口号
     */
    private int port;
 
    /**
     * ftp主机名或IP
     */
    private String host;
 
    /**
     * 连接用户名
     */
    private String user;
 
    /**
     * 连接密码
     */
    private String password;
 
    public ConfigContent() {
 
    }
 
    public ConfigContent(int port, String host, String user, String password) {
        this.port = port;
        this.host = host;
        this.user = user;
        this.password = password;
    }
 
    public int getPort() {
        return port;
    }
 
    public void setPort(int port) {
        this.port = port;
    }
 
    public String getHost() {
        return host;
    }
 
    public void setHost(String host) {
        this.host = host;
    }
 
    public String getUser() {
        return user;
    }
 
    public void setUser(String user) {
        this.user = user;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
 
    public String toString() {
        return user + "/" + password + "@" + host + ":" + port;
    }
}