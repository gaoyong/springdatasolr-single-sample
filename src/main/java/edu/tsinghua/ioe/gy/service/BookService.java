package edu.tsinghua.ioe.gy.service;

import java.util.List;

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
	
	public List<Book> findByName (String name){
//		return bookRepository.findByName(name);
//		return bookRepository.findByNameContains(name);
		return bookRepository.findByQueryAnnotation(name);
	}
	
	public Page<Book> customFindByName (String name){
		return customBookRepository.findProductsByCustomName(name);
	}

}
