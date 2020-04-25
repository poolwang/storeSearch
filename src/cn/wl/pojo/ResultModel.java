package cn.wl.pojo;

import java.util.List;

public class ResultModel {

	private List<Product> productList;
	private Long recordCount;
	private int pageCount;
	private int currentPage;
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public Long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public ResultModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultModel(List<Product> productList, Long recordCount, int pageCount, int currentPage) {
		super();
		this.productList = productList;
		this.recordCount = recordCount;
		this.pageCount = pageCount;
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "ResultModel [productList=" + productList + ", recordCount=" + recordCount + ", pageCount=" + pageCount
				+ ", currentPage=" + currentPage + "]";
	}
	
}
