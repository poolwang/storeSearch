package cn.wl.service;

import cn.wl.pojo.ResultModel;

public interface ProductService {

	public ResultModel queryProduct(String queryString, String cataName, String price, String sort, Integer curPage)
			throws Exception;
}
