package com.itheima.core.dao;


import org.apache.ibatis.annotations.Param;

import com.itheima.core.po.User;

/**
 * User的数据访问类
 * @author 王坤
 */
public interface UserDao {
	//这里使用@Param就是为了，是xml里面能够直接接收到该参数
	public User findUser(@Param("usercode") String usercode,@Param("password") String password);
	
}
