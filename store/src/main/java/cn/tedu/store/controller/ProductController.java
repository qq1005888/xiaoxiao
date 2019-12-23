package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Product;
import cn.tedu.store.service.IProductService;
import cn.tedu.store.util.JsonResult;
/**
 * 处理商品数据相关的控制器
 * @author JAVA
 *
 */
@RestController
@RequestMapping("products")
public class ProductController extends BaseController{
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("{id}/details")
	public JsonResult<Product> getById(@PathVariable("id")Integer id){
		Product data = productService.getById(id);
		return new JsonResult<>(OK,data);
				
		//   http://localhost:8080/products/10000001/details
	}
	@GetMapping("list/new")
	public JsonResult<List<Product>> getNewList(){
		List<Product> data = productService.getNewList();
		return new JsonResult<>(OK,data);
	}
  //  http://localhost:8080/products/list/new
}
