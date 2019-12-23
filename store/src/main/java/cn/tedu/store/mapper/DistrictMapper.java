package cn.tedu.store.mapper;
/**
 * 处理省市区数据的持久层接口
 */
import java.util.List;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;

public interface DistrictMapper {
	/**
	 * 获取全国的省/某市所有的市/某市所有的去的数据列表
	 * @param parent
	 * @return
	 */
	List<District> findByParent(String parent);
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	String findNameByCode(String code);
	
	List<Address> findByUid(Integer uid);

}
