package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.Product;
/**
 * 处理 商品的数据持久层的接口
 * @author JAVA
 *
 */
public interface ProductMapper {

	/**
	 * 获取"新到好货"列表
	 * @return  新到好货  列表
	 */
	List<Product> findNewList();

	/**
	 * 根据商品id，查询商品的详情
	 * @param id商品id
	 * @return匹配的商品详情，如果没有匹配的数据，则返回null
	 */
	Product findById(Integer id);
}
