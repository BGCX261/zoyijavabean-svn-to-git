package org.zoyi.util;

import java.util.List;

public class DataPage {
	/**
	 * 将需要的页的数据封装到一个DataPage中去， 这个类表示了我们需要的一页的数据，<br>
	 * 里面包含有三个元素：datasetSize，startRow，和一个用于表示具体数据的List。<br>
	 * datasetSize表示了这个记录集的总条数，查询数据的时候，使用同样的条件取count即可，<br>
	 * startRow表示该页的起始行在数据库中所有记录集中的位置
	 */

	private int datasetSize;

	private int startRow;

	private List<Object> data;

	/** */
	/**
	 * 
	 * @param datasetSize
	 *            数据集大小
	 * @param startRow
	 *            起始行
	 * @param data
	 *            数据List<Object>
	 */
	public DataPage(int datasetSize, int startRow, List<Object> data) {

		this.datasetSize = datasetSize;

		this.startRow = startRow;

		this.data = data;

	}

	/** */
	/**
	 * 
	 * @return
	 */
	public int getDatasetSize() {

		return datasetSize;

	}

	public int getStartRow() {

		return startRow;

	}

	/** */
	/**
	 * 
	 * @return 已填充好的数据集
	 */
	public List<Object> getData() {
		return data;
	}

}