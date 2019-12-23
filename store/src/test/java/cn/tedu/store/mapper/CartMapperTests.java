package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTests {
	
	@Autowired
	private CartMapper mapper;
	
	@Test
	public void insert() {
		
		Cart cart=new Cart();
		cart.setCid(6);
		cart.setUid(2);
		cart.setPid(33);
		System.err.println(cart);
		Integer rows=mapper.insert(cart);
		System.err.println("rows="+rows);
		System.err.println(cart);
		
	}
	@Test
	public void findByUidAndPid() {
	    Integer uid= 2;
	    Integer pid= 33;
	    Cart result = mapper.findByUidAndPid(uid,pid);
	    System.err.println(result);
	}
	  @Test 
	  public void  updateNumByCid() { 
		 Integer cid=1;
		 Integer num=10;
		 String modifiedUser = "ADMIN";
		 Date modifiedTime = new Date();
		 Integer rows = mapper.updateNumByCid(cid,num,modifiedUser,modifiedTime);
		 System.err.println("rows="+rows);
	  }
	  @Test 
	  public void  findByCid() { 
		  Integer cid=1;
		  Cart rows = mapper.findByCid(cid);
		  System.err.println("rows="+rows);
	  }
	  @Test
	  public void findVOByCids() {
	      Integer[] cids = { 4,7,8 };
	      List<CartVO> list = mapper.findVOByCids(cids);
	      System.err.println("count=" + list.size());
	      for (CartVO item : list) {
	          System.err.println(item);
	      }
	  }
}
