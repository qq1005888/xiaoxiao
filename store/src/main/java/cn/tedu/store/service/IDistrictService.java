package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.District;

public interface IDistrictService {
	
	List<District> getByParent(String parent);
	
	String getNameBuCode(String code);

}
