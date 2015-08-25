package org.zoyi.adapter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.zoyi.vo.NewsCategory;

public class NewsCategoryCollectionAdapter {
	
	public static Map<String, Integer> toMap(List<NewsCategory> allNewsCategory) {
		
		Map<String, Integer> NewsCategoryMapNameId = new TreeMap<String, Integer>();
		for (NewsCategory i : allNewsCategory) {
			NewsCategoryMapNameId.put(i.getNewsCategoryName(), i.getId());
		}
		return NewsCategoryMapNameId;
	}
}
