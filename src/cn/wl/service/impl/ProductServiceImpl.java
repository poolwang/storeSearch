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
        
        //�������ж�
		if (queryString != null && !"".equals(queryString)) {
			query.set("q", queryString);
		}else {
			query.set("q", "*");
		}
		
		//��Ʒ�����ж�
		if (cataName != null && !"".equals(cataName)) {
			query.set("fq", "product_catalog_name:"+cataName);
		}
		
		//�۸�����(��������string����Ҫ�и�������)
		if (price != null && !"".equals(price)) {
			String[] priceArr = price.split("-");
			query.set("fq", "product_price:["+priceArr[0]+" TO "+priceArr[1]+"]");
		}
		
		//����(1�ǵ���)
		if (sort.equals("1")) {
			query.setSort("product_price", ORDER.desc);
		}else {
			query.setSort("product_price", ORDER.asc);
		}
		
		//��ҳ
		if (curPage==null) {
			curPage=1;
		}
		
		//��ʼλ��
		query.setStart((curPage-1)*20);
		
		//ÿҳ����
		query.setRows(20);
		
		query.set("df", "product_name");
		
		
		//��ʼ����
		ResultModel resultModel = productMapper.queryProduct(query);
		//ҳ��
		resultModel.setPageCount((int)Math.ceil(resultModel.getRecordCount().doubleValue()/20));
		//��ǰҳ��
		resultModel.setCurrentPage(curPage);
		return resultModel;
	}

}
