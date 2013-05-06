package com.neaghfoz.common.util;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 分页
 *
 */
@SuppressWarnings("unused")
@Component
@Scope("prototype")
public class Pager implements Serializable {

	private static final long serialVersionUID = 1L;
	private int currentPage = 1;
	private int pageSize = 20;
	private long totalSize = 0;
	private int totalPage = 1;
	private int rowIndex = 0;

	private boolean hasFirst;
	private boolean hasPrevious;
	private boolean hasNext;
	private boolean hasLast;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		try {
			int page = Integer.parseInt(currentPage);
			if (page > 0)
				this.currentPage = page;
		} catch (Exception e) {
		}
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(String rowIndex) {
		this.rowIndex = Integer.parseInt(rowIndex.trim());
	}

	public boolean getHasFirst() {
		return currentPage == 1 ? false : true;
	}

	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}

	public boolean getHasLast() {
		return currentPage == getTotalPage() ? false : true;
	}

	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}

	public boolean getHasNext() {
		return getHasLast() ? true : false;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public boolean getHasPrevious() {
		return getHasFirst() ? true : false;
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		try {
			int size = Integer.parseInt(pageSize);
			if (size > 0 && size <= 1000)
				this.pageSize = size;
		} catch (Exception e) {
		}
	}

	public void setExportPageSize() { // 设置导出excel一页的大小为3000
		this.currentPage = 1;
		this.pageSize = 3000;
	}

	public int getTotalPage() {
		totalPage = (int) (totalSize / pageSize);
		if (totalSize % pageSize != 0)
			totalPage++;
		totalPage = totalPage == 0 ? 1 : totalPage;
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		if (totalSize > -1)
			this.totalSize = totalSize;
		currentPage = currentPage > getTotalPage() ? getTotalPage()
				: currentPage;
	}
}
