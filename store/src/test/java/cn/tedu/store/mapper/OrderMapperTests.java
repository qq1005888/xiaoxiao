package cn.tedu.store.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTests {
	
	    @Autowired
	    private OrderMapper mapper;
	    
	    
	    
	    @Test
	    public void insertOrder() {
	    	 Order order=new  Order();
	    	 order.setUid(1);
	    	 order.setRecvName("小小");
	    	Integer in= mapper.insertOrder(order);
	    	System.out.println("rows"+in);
	    	
	    }
	    @Test
	    public void insertOrderItem() {
	    	 OrderItem orderItem = new OrderItem();
	         orderItem.setOid(1);
	         orderItem.setPid(2);
	         orderItem.setNum(3);
	         Integer rows = mapper.insertOrderItem(orderItem);
	         System.err.println("rows=" + rows);
	    	
	    }
	    

}
