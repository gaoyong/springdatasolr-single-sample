package edu.tsinghua.ioe.gy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import edu.tsinghua.ioe.gy.model.Book;
import edu.tsinghua.ioe.gy.repository.BookRepository;
import edu.tsinghua.ioe.gy.repository.CustomBookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CustomBookRepository customBookRepository;
	
	public void save (Book book){
		if (book == null){
			return ;
		}
		bookRepository.save(book);
	}
	
	public Book findById (String id){
//		return bookRepository.findOne(id);
		return customBookRepository.findProductsByCustom(id);
	}
	
	public Page<Book> findByName (String name){
		return customBookRepository.findProductsByCustomName(name);
	}

}
