package com.itheima.core.dao;

import java.util.List;

import com.itheima.core.po.Customer;

/**
 * �ͻ������ݷ��ʲ�
 * @author ����
 */
public interface CustomerDao {
	//�ͻ��б��ȿ���ȫ����ѯ��Ҳ���Բ��ֲ�ѯ
	public List<Customer> selectCustomerList(Customer customer);
	//�ͻ���
	public Integer selectCustomerListCount(Customer customer);
}
