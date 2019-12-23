package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.vo.CartVO;

/**
 * 
 * @author JAVA
 *
 */
public interface ICartService {
	/**
	 * 
	 * @param uid
	 * @param username
	 * @param pid
	 * @param amount
	 */
	void addToCart(Integer uid, String username, Integer pid, Integer amount);
	
	/**
	 * 查询某用户的购物车数据
	 * @param uid 用户的id
	 * @return 该用户的购物车数据列表
	 */
	List<CartVO> getByUid(Integer uid);
	/**
	 * 
	 * @param cid
	 * @param uid
	 * @param username
	 * @return
	 */
	Integer addNum(Integer cid, Integer uid, String username);
	
	/**
	 * 
	 * @param cids
	 * @return
	 */
	List<CartVO> getVOByCids(Integer[] cids,Integer uid);
	/**
	 * 
	 * @param dids
	 * @param uid
	 */
	void delete(Integer[] cids,Integer uid);
}
