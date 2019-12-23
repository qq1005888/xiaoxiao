package cn.tedu.store.service;
import java.util.List;

import org.junit.Test;
/**
 * 业务层测试
 */
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {
	
	@Autowired
	private IAddressService service;
	
	@Test
	public void addnew() {
		
		try {
			Integer uid=1;
			String username="小二";
			Address address = new Address();
			address.setName("食客");
			service.addnew(uid, username, address);
			System.err.println("ok.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getSimpleName());
			System.err.println(e.getMessage());
		}
		
				
	}
	
	@Test
	public void getByUid() {
		Integer uid = 6;
		List<Address> list = service.getByUid(uid);
		System.err.println("count=" + list.size());
		for (Address item : list) {
			System.err.println(item);
		}
	}
	
	@Test
	public void setDefault() {
		
		try {
			Integer aid=33;
			Integer uid=6;
			String username="管理员";
			service.setDefault(uid,aid, username);
			System.err.println("ok.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getSimpleName());
			System.err.println(e.getMessage());
		}
		
				
	}
	@Test
	public void getByAid() {
	    try {
	        Integer aid = 42;
	        Integer uid = 18;
	        Address result = service.getByAid(aid, uid);
	        System.err.println(result);
	    } catch (ServiceException e) {
	        System.err.println(e.getClass().getSimpleName());
	        System.err.println(e.getMessage());
	    }
	}

}
