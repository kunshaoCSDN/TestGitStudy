package com.itheima.core.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.common.utils.Page;
import com.itheima.core.dao.CustomerDao;
import com.itheima.core.po.Customer;
import com.itheima.core.service.CustomerService;
//**************��Ҫ��ҵ���߼���һ��Ҫ��������Ĺ���*******************
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	@Override
	public Page<Customer> selectCustomerList(Integer page, 
										Integer rows, 
										String custName,String custSource,
										String custIndustry,String custLevel) {
		//�����ͻ�����
		Customer customer = new Customer();
		//�жϿͻ�����
		if(StringUtils.isNotBlank(custName)){
			customer.setCust_name(custName);
		}
		//�жϿͻ���Ϣ��Դ
		if(StringUtils.isNotBlank(custSource)){
			customer.setCust_source(custSource);
		}
		//�жϿͻ�������ҵ
		if(StringUtils.isNotBlank(custIndustry)){
			customer.setCust_industry(custIndustry);
		}
		//�жϿͻ���������
		if(StringUtils.isNotBlank(custLevel)){
			customer.setCust_level(custLevel);
		}
		//��ǰҳ
		customer.setStart((page - 1) * rows); 
		customer.setRows(rows);
		//����CustomerDao��ȡ����
		List<Customer> customers = this.customerDao.selectCustomerList(customer);
		//��ȡ��һ�β����ж���ҳ
		Integer count = this.customerDao.selectCustomerListCount(customer);
		//����Page���ض���
		Page<Customer> result = new Page<Customer>();
		result.setPage(page);	 //��ʾҳ��
		result.setRows(customers);//��ʾ������
		result.setSize(rows);    //һҳ�ж�������
		result.setTotal(count);	//һ���ж�������
		return result;
	}

}
