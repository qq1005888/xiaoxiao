package cn.tedu.store.service;

import cn.tedu.store.entity.Order;
/**
 * 
 * @author JAVA
 *
 */
public interface IOrderService {
	/**
	 * 
	 * @param uid
	 * @param username
	 * @param aid
	 * @param cids
	 * @return
	 */
	Order create(Integer uid, String username, Integer aid, Integer cids);
	

}
