package org.zoyi.service;

import java.util.List;

import org.zoyi.vo.*;

public interface GroupCategoryService extends Base<GroupCategory> {

	List<GroupCategory> queryAll() throws Exception;

}
