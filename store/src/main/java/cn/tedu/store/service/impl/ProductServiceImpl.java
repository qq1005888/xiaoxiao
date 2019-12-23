package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Product;
import cn.tedu.store.mapper.ProductMapper;
import cn.tedu.store.service.IProductService;
import cn.tedu.store.service.ex.ProductNotFoundException;

/**
 * 处理商品数据的业务层实现类
 */
@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public Product getById(Integer id) {
		Product result = findById(id);
		if (result == null) {
			throw new ProductNotFoundException(
				"尝试访问的商品数据不存在");
		}
		
		result.setStatus(null);
		result.setPriority(null);
		result.setCreatedUser(null);
		result.setCreatedTime(null);
		result.setModifiedUser(null);
		result.setModifiedTime(null);
		
		return result;
	}
	
	@Override
	public List<Product> getNewList() {
		List<Product> list = findNewList();
		for (Product product : list) {
			product.setStatus(null);
			product.setPriority(null);
			product.setCreatedUser(null);
			product.setCreatedTime(null);
			product.setModifiedUser(null);
			product.setModifiedTime(null);
		}
		return list;
	}
	
	/**
	 * 根据商品id，查询商品详情
	 * @param id 商品id
	 * @return 匹配的商品详情，如果没有匹配的数据，则返回null
	 */
	private Product findById(Integer id) {
		return productMapper.findById(id);
	}
	
	/**
	 * 获取“新到好货”列表
	 * @return “新到好货”列表
	 */
	private List<Product> findNewList() {
		return productMapper.findNewList();
	}


}








