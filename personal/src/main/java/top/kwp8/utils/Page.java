package top.kwp8.utils;

import java.util.List;

public class Page<T> {

	private Long total;
	private List<T> rows;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public Page(Long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	
}
