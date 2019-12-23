package cn.tedu.store.mapper;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
/**
 * 处理订单数据和订单商品的持久层
 * @author JAVA
 *
 */
public interface OrderMapper {
	
	/**
	 * 插入订单数据
	 * @param order
	 * @return
	 */
	Integer insertOrder(Order order);

	/**
	 * 插入订单商品数据
	 * @param orderItem
	 * @return
	 */
	Integer insertOrderItem(OrderItem orderItem);
}
