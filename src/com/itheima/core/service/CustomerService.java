package com.itheima.core.service;


import com.itheima.common.utils.Page;
import com.itheima.core.po.Customer;

/**
 * �ͻ���ҵ���߼���
 * @author ����
 */
public interface CustomerService {
	public Page<Customer> selectCustomerList(Integer page, 
			Integer rows, 
            String custName,String custSource,
            String custIndustry,String custLevel);
}
