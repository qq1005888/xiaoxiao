package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

/**
 * 处理购物车数据的持久层
 * @author JAVA
 *
 */
public interface CartMapper {
	/**
	 * 
	 * @param cart
	 * @return
	 */
	Integer insert(Cart cart);
   /**
    * 修改购物车
    * @param cid
    * @param num
    * @param modifiedUser
    * @param modifiedTime
    * @return
    */
	Integer updateNumByCid(
	    @Param("cid") Integer cid, 
	    @Param("num") Integer num, 
	    @Param("modifiedUser") String modifiedUser, 
	    @Param("modifiedTime") Date modifiedTime);
    /**
     * 根据用户id和商品id查询购物车数据
     * @param uid
     * @param pid
     * @return
     */
	Cart findByUidAndPid(
	    @Param("uid") Integer uid, 
	    @Param("pid") Integer pid);
	/**
	 * 
	 * @param uid
	 * @return
	 */
	List<CartVO> findVOByUid(Integer uid);
	
	/**
	 * 
	 * @param cid
	 * @return
	 */
	Cart findByCid(Integer cid);
	/**
	 * 
	 * @param cids
	 * @return
	 */
	List<CartVO> findVOByCids(Integer[] cids);
	
	/**
	 * 删除购物车中的数据
	 * @param cids
	 * @return
	 */
	Integer deleteByCids(Integer[] cids);

}
