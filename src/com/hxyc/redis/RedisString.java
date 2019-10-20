package com.hxyc.redis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisString {

	public static void main(String[] args) {
		
		/**
		 * 通过网络，访问redis服务器：
		 * 1、修改redis.conf，启动redis需要指定redis.conf的位置
		 * 2、关闭linux防火墙，或者让redis的端口号通过防火墙
		 */
		
		//创建Jedis对象，指定连接的redis服务器的ip,端口
		 /**
		  * String host:redis所在的linux服务器的ip
		  * int port:redis运行的端口号
		  */
		String host = "127.0.0.1";
		int port = 6379;
		Jedis jedis = new Jedis(host, port);
		
		//设置访问密码
		//jedis.auth("123456");
		
		//调用Jedis对象的方法，操作Redis数据
		jedis.set("break","豆浆和油条");
		
		//获取key的值
		String value = jedis.get("break");
		System.out.println("value :"+value);
		
		//mset一次创建多个key-value
		jedis.mset("lunch","红烧肉","dinner","面条");
		
		//获取多个key对应的值  mget
		List<String> values = jedis.mget("break","lunch","dinner");
		
		for (String string : values) {
			System.out.println(string);
		}
	}

}
