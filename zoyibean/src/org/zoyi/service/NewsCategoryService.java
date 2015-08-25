package org.zoyi.service;

import java.util.List;

import org.zoyi.vo.*;

public interface NewsCategoryService extends Base<NewsCategory> {

	List<NewsCategory> queryAll() throws Exception;


}
