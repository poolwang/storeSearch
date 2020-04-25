package cn.wl.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.wl.mapper.ProductMapper;
import cn.wl.pojo.Product;
import cn.wl.pojo.ResultModel;

@Repository
public class ProductMapperImpl implements ProductMapper {

	@Autowired
	private HttpSolrServer httpSolrServer;
	
	@Override
	public ResultModel queryProduct(SolrQuery query) throws Exception {
        ResultModel resultModel=new ResultModel();
        //solr里面查到的数据
        QueryResponse response = httpSolrServer.query(query);
        SolrDocumentList results = response.getResults();
        
        Product product=null;
        List<Product> productList=new ArrayList<>();
		for (SolrDocument result : results) {
			product.setPid((String) result.get("id"));
			product.setName((String) result.get("product_name"));
			product.setCatalogName((String) result.get("product_catalog_name"));
			product.setDescription((String) result.get("product_description"));
			product.setPrice((double) result.get("product_price"));
			product.setPicture((String) result.get("product_picture"));
			productList.add(product);
		}
       //要返回的上面查到的数据集合
		resultModel.setProductList(productList);
		//查询总数
        resultModel.setRecordCount(results.getNumFound());
        
		return resultModel;
	}

}
