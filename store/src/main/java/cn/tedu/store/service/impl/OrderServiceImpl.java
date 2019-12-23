package cn.tedu.store.service.impl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IOrderService;
import cn.tedu.store.service.ex.InsertException;
@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired 
	private OrderMapper orderMapper;  //持久层对象
	@Autowired  
	private IAddressService addressService;  //处理收货地址数据的业务对象
	@Autowired 
	private ICartService cartService; //处理购物车数据的业务对象
	
	
	
	
	
	/**
	 * 插入订单数据
	 * @param order 订单数据
	 */
	private void insertOrder(Order order) {
	    Integer rows = orderMapper.insertOrder(order);
	    if (rows != 1) {
	        throw new InsertException(
	            "插入订单数据时出现未知错误，请联系系统管理员");
	    }
	}

	/**
	 * 插入订单商品数据
	 * @param orderItem 订单商品数据
	 */
	private void insertOrderItem(OrderItem orderItem) {
	    Integer rows = orderMapper.insertOrderItem(orderItem);
	    if (rows != 1) {
	        throw new InsertException(
	            "插入订单商品数据时出现未知错误，请联系系统管理员");
	    }
	}

	@Override
	public Order create(Integer uid, String username, Integer aid, Integer cids) {
		// 创建当前时间对象now
	    // 调用IAddressService对象的getByAid(Integer aid, Integer uid)方法，根据参数aid和uid查询收货地址数据

	    // 调用ICartService对象的getVOByCids(Integer cids, Integer uid)方法，根据参数cids和uid查询匹配的购物车数据，得到List<CartVO>对象
	    // 声明变量totalPrice表示订单中商品的总价
	    // 遍历以上查询到的List<CartVO>对象
	    // -- 在totalPrice上累加商品的单价与数量的乘积

	    // 创建Order对象
	    // 补全数据：uid
	    // 补全数据：recv_???(通过查询到的收货地址数据)
	    // 补全数据：total_price(totalPrice)
	    // 补全数据：order_time(now)
	    // 补全数据：pay_time(保留为null)
	    // 补全数据：status(0)
	    // 补全数据：4条日志
	    // 插入订单数据：insertOrder(Order order);

	    // 遍历查询到的List<CartVO>对象
	    // -- 创建OrderItem对象
	    // -- 补全数据：oid(order.getOid())
	    // -- 补全数据：pid, title, image, price, num(均从CartVO对象中获取)
	    // -- 补全数据：4条日志
	    // -- 调用insertOrderItem(OrderItem orderItem)插入订单商品数据

	    // 将Order对象中的4条日志设置为null
	    // 返回Order对象
		return null;
	}

}
