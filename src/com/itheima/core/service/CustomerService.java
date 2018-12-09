package com.itheima.core.service;


import com.itheima.common.utils.Page;
import com.itheima.core.po.Customer;

/**
 * 客户的业务逻辑类
 * @author 王坤
 */
public interface CustomerService {
	public Page<Customer> selectCustomerList(Integer page, 
			Integer rows, 
            String custName,String custSource,
            String custIndustry,String custLevel);
}
