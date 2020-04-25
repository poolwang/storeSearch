package cn.wl.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wl.mapper.ProductMapper;
import cn.wl.pojo.ResultModel;
import cn.wl.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public ResultModel queryProduct(String queryString, String cataName, String price, String sort, Integer curPage)
			throws Exception {
        SolrQuery query=new SolrQuery();
        
        //搜索框判断
		if (queryString != null && !"".equals(queryString)) {
			query.set("q", queryString);
		}else {
			query.set("q", "*");
		}
		
		//商品类型判断
		if (cataName != null && !"".equals(cataName)) {
			query.set("fq", "product_catalog_name:"+cataName);
		}
		
		//价格区间(传过来是string，需要切割再重组)
		if (price != null && !"".equals(price)) {
			String[] priceArr = price.split("-");
			query.set("fq", "product_price:["+priceArr[0]+" TO "+priceArr[1]+"]");
		}
		
		//排序(1是倒叙)
		if (sort.equals("1")) {
			query.setSort("product_price", ORDER.desc);
		}else {
			query.setSort("product_price", ORDER.asc);
		}
		
		//分页
		if (curPage==null) {
			curPage=1;
		}
		
		//起始位置
		query.setStart((curPage-1)*20);
		
		//每页条数
		query.setRows(20);
		
		query.set("df", "product_name");
		
		
		//开始查找
		ResultModel resultModel = productMapper.queryProduct(query);
		//页数
		resultModel.setPageCount((int)Math.ceil(resultModel.getRecordCount().doubleValue()/20));
		//当前页数
		resultModel.setCurrentPage(curPage);
		return resultModel;
	}

}
