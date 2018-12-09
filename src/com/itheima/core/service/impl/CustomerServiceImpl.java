package com.itheima.core.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.common.utils.Page;
import com.itheima.core.dao.CustomerDao;
import com.itheima.core.po.Customer;
import com.itheima.core.service.CustomerService;
//**************重要的业务逻辑层一定要进行事务的管理*******************
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	@Override
	public Page<Customer> selectCustomerList(Integer page, 
										Integer rows, 
										String custName,String custSource,
										String custIndustry,String custLevel) {
		//创建客户对象
		Customer customer = new Customer();
		//判断客户名称
		if(StringUtils.isNotBlank(custName)){
			customer.setCust_name(custName);
		}
		//判断客户信息来源
		if(StringUtils.isNotBlank(custSource)){
			customer.setCust_source(custSource);
		}
		//判断客户所属事业
		if(StringUtils.isNotBlank(custIndustry)){
			customer.setCust_industry(custIndustry);
		}
		//判断客户所属级别
		if(StringUtils.isNotBlank(custLevel)){
			customer.setCust_level(custLevel);
		}
		//当前页
		customer.setStart((page - 1) * rows); 
		customer.setRows(rows);
		//调用CustomerDao获取数据
		List<Customer> customers = this.customerDao.selectCustomerList(customer);
		//获取这一次查找有多少页
		Integer count = this.customerDao.selectCustomerListCount(customer);
		//创建Page返回对象
		Page<Customer> result = new Page<Customer>();
		result.setPage(page);	 //显示页数
		result.setRows(customers);//显示的数据
		result.setSize(rows);    //一页有多少数据
		result.setTotal(count);	//一共有多少数据
		return result;
	}

}
