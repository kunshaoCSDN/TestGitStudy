package com.itheima.core.dao;
import java.util.List;
import com.itheima.core.po.BaseDict;
/**
 * 数据字典的数据操作类
 * @author 王坤
 */
public interface BaseDictDao {
	public List<BaseDict> selectBaseDictList(String typeCode);
}
