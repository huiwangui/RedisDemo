RedisDemo:使用Jedis工具库在java代码中操作Redis数据库的数据

步骤：
1、新建java project
2、导入jedis的jar:jedis-2.9.0.jar
3、新建类，创建Jedis对象、调用它的方法、实现数据的处理


Jedis在单独使用过程中，存在线程不安全的问题，解决办法是Jedis一般与commons-pool一起使用
commons-pool：线程池