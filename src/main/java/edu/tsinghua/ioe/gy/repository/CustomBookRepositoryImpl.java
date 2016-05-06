package edu.tsinghua.ioe.gy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.SimpleStringCriteria;
import org.springframework.stereotype.Component;

import edu.tsinghua.ioe.gy.model.Book;

/**
 * 获取到SolrOperations的url总是没有core的信息，所以不得不手动配置了几个SolrClient装配上
 * 这个处理应该不是SpringDataSolr的官方推荐方法，待研究
 * @author gaoyong
 *
 */
@Component
public class CustomBookRepositoryImpl implements CustomBookRepository{

	@Autowired@Qualifier("testCore")
	private SolrOperations solrTemplate;
	
	public Book findProductsByCustom(String id) {
//		solrTemplate.getSolrClient();
		if (solrTemplate instanceof SolrTemplate){
			SolrTemplate template = (SolrTemplate)solrTemplate;
			template.setSolrCore("test");
			return template.queryForObject(new SimpleQuery(new Criteria("id").is(id)), Book.class);
		}
		
		return null;
	}

	/**
	 * 目前这种使用SolrTemplate方法还有问题
	 */
	public Page<Book> findProductsByCustomName(String name) {
			Query query = new SimpleQuery(new SimpleStringCriteria("name:山海经"));
			return solrTemplate.queryForPage(query, Book.class);
		
	}	
}
