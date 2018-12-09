package com.itheima.core.service;
import java.util.List;
import com.itheima.core.po.BaseDict;
/**
 * BaseDict的业务层接口
 * @author 王坤
 */
public interface BaseDictService {
	public List<BaseDict> selectBaseDictList(String typeCode);
}
