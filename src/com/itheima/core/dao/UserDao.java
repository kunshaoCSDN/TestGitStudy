package com.itheima.core.dao;


import org.apache.ibatis.annotations.Param;

import com.itheima.core.po.User;

/**
 * User�����ݷ�����
 * @author ����
 */
public interface UserDao {
	//����ʹ��@Param����Ϊ�ˣ���xml�����ܹ�ֱ�ӽ��յ��ò���
	public User findUser(@Param("usercode") String usercode,@Param("password") String password);
	
}
