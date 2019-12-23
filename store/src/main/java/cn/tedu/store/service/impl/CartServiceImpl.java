package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.Product;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IProductService;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.vo.CartVO;

/**
 * 处理购物车数据的业务层实现类
 */
@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private IProductService productService;

	@Override
	public void addToCart(Integer uid, String username, Integer pid, Integer amount) {
		// 创建当前时间对象now(new Date())
		Date now = new Date();
		// 调用当前业务实现类的私有findByUidAndPid(Integer uid, Integer pid)方法执行查询
		Cart result = findByUidAndPid(uid, pid);
		// 判断查询结果是否为null
		if (result == null) {
			// 是：找不到数据，表示该用户的购物车中没有该商品，则需要插入新的记录
			// 调用productService的getById(Integer id)方法，根据参数pid查询商品数据，从中得到商品单价
			Product product = productService.getById(pid);
			// 创建新的Cart对象
			Cart cart = new Cart();
			// 补全数据：uid
			cart.setUid(uid);
			// 补全数据：pid
			cart.setPid(pid);
			// 补全数据：num(amount)
			cart.setNum(amount);
			// 补全数据：price
			cart.setPrice(product.getPrice());
			// 补全数据：4个日志(username, now)
			cart.setCreatedUser(username);
			cart.setCreatedTime(now);
			cart.setModifiedUser(username);
			cart.setModifiedTime(now);
			// 调用当前业务实现类私有的insert(Cart cart)执行插入数据
			insert(cart);
		} else {
			// 否：找到了数据，表示该用户的购物车中已有该商品，则需要修改商品数量
			// 从查询结果中获取cid，用于最终调用修改数量的方法
			Integer cid = result.getCid();
			// 从查询结果中取出num，即原有的数量，与参数amount(增量)相加，得到新的数量，用于最终调用修改数量的方法
			Integer newNum = result.getNum() + amount;
			// -- 调用当前业务实现类私有的updateNumByCid(Integer cid, Integer num, String modifiedUser,
			// Date modifiedTime)执行修改商品数量
			updateNumByCid(cid, newNum, username, now);
		}
	}

	/**
	 * 插入购物车数据
	 * 
	 * @param cart 购物车数据
	 */
	private void insert(Cart cart) {
		Integer rows = cartMapper.insert(cart);
		if (rows != 1) {
			throw new InsertException("插入购物车数据时出现未知错误，请联系系统管理员");
		}
	}

	/**
	 * 修改购物车中商品的数量
	 * 
	 * @param cid          购物车数据的id
	 * @param num          新的数量
	 * @param modifiedUser 修改执行人
	 * @param modifiedTime 修改时间
	 */
	private void updateNumByCid(Integer cid, Integer num, String modifiedUser, Date modifiedTime) {
		Integer rows = cartMapper.updateNumByCid(cid, num, modifiedUser, modifiedTime);
		if (rows != 1) {
			throw new UpdateException("更新购物车中的商品数量时出现未知错误，请联系系统管理员");
		}
	}

	/**
	 * 根据用户id和商品id查询购物车数据
	 * 
	 * @param uid 用户id
	 * @param pid 商品id
	 * @return 匹配的购物车数据，如果没有匹配的数据，则返回null
	 */
	private Cart findByUidAndPid(Integer uid, Integer pid) {
		return cartMapper.findByUidAndPid(uid, pid);
	}

	/**
	 * 查询某用户的购物车数据
	 * 
	 * @param uid 用户的id
	 * @return 该用户的购物车数据列表
	 */
	private List<CartVO> findVOByUid(Integer uid) {
		return cartMapper.findVOByUid(uid);
	}

	@Override
	public List<CartVO> getByUid(Integer uid) {
		return findVOByUid(uid);
	}

	@Override
	public Integer addNum(Integer cid, Integer uid, String username) {
		// 调用findByCid(Integer cid)方法，根据参数cid查询购物车数据
		Cart result = findByCid(cid);
		// 判断查询结果是否为null
		if (result == null) {
			// 是：CartNotFoundException
			throw new CartNotFoundException("尝试访问的购物车不存在");
		}
		// 使用equals()方法判断查询结果中的uid与参数uid是否不同
		if (!result.getUid().equals(uid)) {
			// 是：抛出AccessDeniedException
			throw new AccessDeniedException("非法访问");
		}

		// 从查询结果中取出原数量，加1后得到新的数量
         Integer newNum= result.getUid()+1;
		// TODO 可以添加一些自定义的规则，例如每个商品的数量上限是99
		// 调用updateNumByCid(Integer cid, Integer num, String modifiedUser, Date
         
		// modifiedTime)方法更新购物车中商品的数量
         updateNumByCid(cid, newNum,username,new Date());
		// 返回新的数量
		return newNum;
	}

	
	  private Cart findByCid(Integer cid) {
	  return cartMapper.findByCid(cid);  
	  }

	@Override
	public List<CartVO> getVOByCids(Integer[] cids,Integer uid) {
		//执行查询数据
		List<CartVO> lc=findVOByCids(cids);
		//遍历查询结果,对比uid，并移除不是当前用户的数据
		//迭代器:是一种安全的，在遍历过程中移除当前集合中的元素的工具、
		Iterator<CartVO> it = lc.iterator();
		while(it.hasNext()) {
			CartVO cart = it.next();
			if(!cart.getUid().equals(uid)) {
				it.remove();
			}
		}
		
		//返回数据
		return lc;
	}
	
	/**
	 * 
	 */
	List<CartVO> findVOByCids(Integer[] cids){
		return cartMapper.findVOByCids(cids);
	}

	@Override
	public void delete(Integer[] cids, Integer uid) {
		//根据参数cids调用业务的getVOBydids()方法,得到List<CartVO>
		List<CartVO> carts=getVOByCids(cids,uid);
		Integer rows=cartMapper.deleteByCids(cids);
		if(carts.size()==0) {
			
		}
		//通过以上查询结果得到有效的，新的cids数组
		
		//根据新的cids调用持久层对象删除购物车数据
		
	}
	 

}
