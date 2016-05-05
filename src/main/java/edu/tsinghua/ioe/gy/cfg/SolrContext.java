package edu.tsinghua.ioe.gy.cfg;

import java.net.MalformedURLException;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = { "edu.tsinghua.ioe.gy.repository" }, multicoreSupport = true)
public class SolrContext {

	private @Resource Environment env;

	@Bean
	public SolrClient solrClient() throws MalformedURLException, IllegalStateException {
		// return new HttpSolrClient(env.getRequiredProperty("solr.host"));
		return new HttpSolrClient("http://localhost:8983/solr/test");
	}

	@Bean
	public SolrOperations solrTemplate() throws Exception {
		SolrTemplate template = new SolrTemplate(solrClient());
//		template.setSolrCore("test");
		return template;
	}
	

}
