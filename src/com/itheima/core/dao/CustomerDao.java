package com.itheima.core.dao;

import java.util.List;

import com.itheima.core.po.Customer;

/**
 * 客户的数据访问层
 * @author 王坤
 */
public interface CustomerDao {
	//客户列表，既可以全部查询，也可以部分查询
	public List<Customer> selectCustomerList(Customer customer);
	//客户数
	public Integer selectCustomerListCount(Customer customer);
}
