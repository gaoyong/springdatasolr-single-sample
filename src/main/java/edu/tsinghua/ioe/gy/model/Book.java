package edu.tsinghua.ioe.gy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * 这里@SolrDocument(solrCoreName = "test") 可以不设置，取决于SolrContext的配置
 * @author gaoyong
 *
 */
//@SolrDocument(solrCoreName = "test")
public class Book {
	
	@Id
	@Indexed
	private String id;
	
	
	private @Indexed("name") String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
