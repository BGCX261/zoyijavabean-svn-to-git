package org.zoyi.service;

import java.util.List;

import org.zoyi.vo.* ;

public interface BenifitActivityCategoryService extends Base<BenifitActivityCategory> {
	public int getCount() throws Exception;
	public List<Object> queryByPage(int startRow,int pageSize) throws Exception;
	List<BenifitActivityCategory> queryAll() throws Exception;
}