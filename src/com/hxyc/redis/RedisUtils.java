package com.hxyc.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.util.Pool;

public class RedisUtils {
	
	public static JedisPool pool;
	
	//创建JedisPool对象
	public static JedisPool open(String ip,int port){
		if(pool == null){
			//创建JedisPool对象
			//创建JedisPoolConfig，给config设置连接池的参数，使用config对象创建JedisPool
			JedisPoolConfig config = new JedisPoolConfig();
			
			//给config设置连接池的参数
			
			//设置最大的线程数，一个线程就是一个Jedis
			config.setMaxTotal(20);
			
			//设置最大空闲数
			config.setMaxIdle(2);
			
			//设置检查项为true,表示从线程池中获取的对象一定是经过检查可用
			config.setTestOnBorrow(true);
			
			//创建pool对象
			/**
			 * poolConfig:配置器 JedisPoolConfig
			 * host：redis所在的linux的ip
			 * port:redis的端口
			 * timeout：连接redis的超时，毫秒
			 */
			pool = new JedisPool(config, ip, port, 6000);
		}
		return pool;
	}
	
	//关闭Pool对象
	public static void close(){
		if(pool != null){
			pool.close();
		}
	}
}
