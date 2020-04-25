package cn.wl.config;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages="cn.wl")
@PropertySource(value="classpath:sys.properties",encoding="utf-8")
public class ContextConfig {

	@Value(value = "${solr.baseURL}")
	private String baseURL;
	@Bean
	public HttpSolrServer getSolrServer() {
		HttpSolrServer solrServer=new HttpSolrServer(baseURL);
		return solrServer;
	}
}
