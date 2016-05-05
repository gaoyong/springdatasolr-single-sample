package edu.tsinghua.ioe.gy.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import edu.tsinghua.ioe.gy.model.Book;

public interface BookRepository  extends  SolrCrudRepository<Book,String>{
	
//	public List<Book> findByName(String name);
	
//	@Query("name:*?0* ")
//    public List<Book> findByQueryAnnotation(String searchTerm);

}
