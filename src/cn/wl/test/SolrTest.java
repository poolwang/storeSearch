package cn.wl.test;

import org.apache.solr.client.solrj.SolrQuery;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.wl.config.ContextConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ContextConfig.class})
@WebAppConfiguration
public class SolrTest {

	@Autowired
	private HttpSolrServer solrServer;
	@Test
	public void queryIndex() throws SolrServerException {
		SolrQuery query=new SolrQuery("product_name:*");
		QueryResponse response = solrServer.query(query);
		SolrDocumentList results = response.getResults();
		for (SolrDocument solrDocument : results) {
			System.out.print("��Ʒid:"+solrDocument.get("id"));
			System.out.print(" ��Ʒ����:"+solrDocument.get("product_name"));
			System.out.print(" ��Ʒ�۸�:"+solrDocument.get("product_price"));		
			System.out.print(" ��Ʒ���:"+solrDocument.get("product_catalog_name"));
			System.out.println("��ƷͼƬ:"+solrDocument.get("product_picture"));
		}
		long cnt = results.getNumFound();
		System.out.println("��ѯ�������:" + cnt);
	}
}
