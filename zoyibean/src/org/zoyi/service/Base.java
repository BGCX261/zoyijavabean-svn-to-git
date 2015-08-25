/**
 * 
 */
package org.zoyi.service;

import java.util.List;

/**
 * @author dhibmclub
 *
 */
public interface Base<T> {
	public String add(T t) throws Exception;
	public String deleteById(int id) throws Exception;
	public String delete(List<Integer> id) throws Exception;
	public String modify(T t) throws Exception;
	public T queryById(int id) throws Exception;
	// u should check what is unique,if exist u give me "y",if not u give me "n"
	public String isExist(T t) throws Exception;
	public String isExist(int id) throws Exception;
}