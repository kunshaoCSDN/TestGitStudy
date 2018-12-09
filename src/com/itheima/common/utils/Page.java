package com.itheima.common.utils;
import java.util.List;
public class Page<T> {   
	private int total;    // 鎬绘潯鏁�?
	private int page;     // 褰撳墠椤�?
	private int size;     // 姣忛〉鏁�?
	private List<T> rows; // 缁撴灉闆�?
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}  
}
