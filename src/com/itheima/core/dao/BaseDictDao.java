package com.itheima.core.dao;
import java.util.List;
import com.itheima.core.po.BaseDict;
/**
 * �����ֵ�����ݲ�����
 * @author ����
 */
public interface BaseDictDao {
	public List<BaseDict> selectBaseDictList(String typeCode);
}
