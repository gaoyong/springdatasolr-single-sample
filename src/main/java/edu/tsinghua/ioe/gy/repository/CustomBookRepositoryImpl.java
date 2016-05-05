package edu.tsinghua.ioe.gy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.SimpleStringCriteria;
import org.springframework.stereotype.Component;

import edu.tsinghua.ioe.gy.model.Book;

@Component
public class CustomBookRepositoryImpl implements CustomBookRepository{

	@Autowired
	private SolrOperations solrTemplate;
	
	public Book findProductsByCustom(String id) {
//		solrTemplate.getSolrClient();
		return solrTemplate.queryForObject(new SimpleQuery(new Criteria("id").is(id)), Book.class);
//		return null;
	}

	public Page<Book> findProductsByCustomName(String name) {
		Query query = new SimpleQuery(new SimpleStringCriteria("name:山海经"));
		return solrTemplate.queryForPage(query, Book.class);
	}	
}
