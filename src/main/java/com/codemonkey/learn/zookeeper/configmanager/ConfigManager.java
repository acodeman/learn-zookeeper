package com.codemonkey.learn.zookeeper.configmanager;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.alibaba.fastjson.JSON;

public class ConfigManager {
	private Jedis jedis;
	private JedisPool jedisPool;

	public ConfigManager() {
		JedisPoolConfig c = new JedisPoolConfig();
		c.setMaxIdle(5);
		c.setTestOnBorrow(false);
		jedisPool = new JedisPool(c, "127.0.0.1", 6379);
		jedis = jedisPool.getResource();
		jedis.auth("foobared");
	}

	/**
	 * 模拟从db加载初始配置
	 * 
	 * @return
	 */
	public String loadFromDB() {
		return jedis.get("config");
	}

	/**
	 * 模拟更新DB中的配置
	 * 
	 * @param port
	 * @param host
	 * @param user
	 * @param password
	 */
	public void updateToDB(String configContent) {
		jedis.set("config", JSON.toJSONString(configContent));
	}

}