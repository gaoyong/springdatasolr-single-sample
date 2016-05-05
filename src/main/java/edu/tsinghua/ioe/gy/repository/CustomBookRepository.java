package edu.tsinghua.ioe.gy.repository;

import org.springframework.data.domain.Page;

import edu.tsinghua.ioe.gy.model.Book;

public interface CustomBookRepository {
	
	Book findProductsByCustom(String id);
	
	 Page<Book> findProductsByCustomName(String name);

}
