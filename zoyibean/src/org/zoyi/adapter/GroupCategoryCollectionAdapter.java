package org.zoyi.adapter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.zoyi.vo.*;

public class GroupCategoryCollectionAdapter {

	public GroupCategoryCollectionAdapter() {
		// TODO Auto-generated constructor stub
	}

	public static Map<String, Integer> toMap(
			List<GroupCategory> allGroupCategory) {
		Map<String, Integer> GroupCategoryMapNameId = new TreeMap<String, Integer>();
		for (GroupCategory i : allGroupCategory) {
			GroupCategoryMapNameId.put(i.getTitle(), i.getId());
		}
		return GroupCategoryMapNameId;
	}

}
