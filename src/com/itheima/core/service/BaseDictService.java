package com.itheima.core.service;
import java.util.List;
import com.itheima.core.po.BaseDict;
/**
 * BaseDict��ҵ���ӿ�
 * @author ����
 */
public interface BaseDictService {
	public List<BaseDict> selectBaseDictList(String typeCode);
}
