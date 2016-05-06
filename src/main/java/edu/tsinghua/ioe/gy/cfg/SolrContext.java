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
import org.springframework.data.solr.server.support.HttpSolrClientFactoryBean;

@Configuration
@EnableSolrRepositories(basePackages = { "edu.tsinghua.ioe.gy.repository" }, multicoreSupport = true)
public class SolrContext {

	private @Resource Environment env;

	@Bean
	public SolrClient solrClient() throws MalformedURLException, IllegalStateException {
		// return new HttpSolrClient(env.getRequiredProperty("solr.host"));
		return new HttpSolrClient("http://localhost:8983/solr/");
	}
	
	@Bean
	public SolrClient solrClientTest() throws MalformedURLException, IllegalStateException {
		// return new HttpSolrClient(env.getRequiredProperty("solr.host"));
		return new HttpSolrClient("http://localhost:8983/solr/test");
	}

	@Bean
	public HttpSolrClientFactoryBean solrClientFactoryBean() {
		HttpSolrClientFactoryBean factory = new HttpSolrClientFactoryBean();
		factory.setUrl("http://localhost:8983/solr/");
//		factory.setUrl(environment.getRequiredProperty(PROPERTY_NAME_SOLR_SERVER_URL));

		return factory;
	}

	@Bean
	public SolrOperations solrTemplate() throws Exception {
		SolrTemplate template = new SolrTemplate(solrClientFactoryBean().getObject());
		return template;
	}
	
	@Bean(name = "testCore")
	public SolrOperations solrTemplateCoreTest() throws Exception {
		SolrTemplate template = new SolrTemplate(solrClientTest());
		return template;
	}

}
