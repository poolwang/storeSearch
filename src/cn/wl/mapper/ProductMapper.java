package cn.wl.mapper;

import org.apache.solr.client.solrj.SolrQuery;

import cn.wl.pojo.ResultModel;

public interface ProductMapper {

	public ResultModel queryProduct(SolrQuery query) throws Exception;
}
