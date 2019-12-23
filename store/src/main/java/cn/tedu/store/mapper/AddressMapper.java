package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Address;
/**
 * 处理收货地址数据
 * @author JAVA
 *
 */
public interface AddressMapper {
	/**
	 * 插入收货地址数据
	 * @param address  收货地址
	 * @return
	 */
	Integer insert(Address address);
	
	/**
	 * 统计某用户的收货地址数据的数量
	 * @param uid  用户的id
	 * @return
	 */
	Integer countByUid(Integer uid);
	
	List<Address> findByUid(Integer uid);
	
	
	// 将指定的收货地址设置为默认
	Integer updateDefaultByAid(
	    @Param("aid") Integer aid, 
	    @Param("modifiedUser") String modifiedUser, 
	    @Param("modifiedTime") Date modifiedTime);
	
	/**
	 * 将某用户的所有收货地址全部设置为默认
	 * @param 
	 * @return
	 */
	Integer updateNonDefaultByUid(Integer uid);
	
	/**
	 * 根据收货地址id查询详情
	 * @param aid
	 * @return
	 */
	Address findByAid(Integer aid);
	/**
	 * 删除
	 * @param aid
	 * @return
	 */
	Integer deleteByAid(Integer aid);
	
	/**
	 * 
	 * @param uid
	 * @return
	 */
	Address findLastModified(Integer uid);

	

	

}
