package edu.tsinghua.ioe.gy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.tsinghua.ioe.gy.model.Book;
import edu.tsinghua.ioe.gy.service.BookService;

@EnableAutoConfiguration
@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/save")
	public String saveBookIndex(@RequestBody Book book) {
		bookService.save(book);
		return "save success";
	}
	
	@RequestMapping("/show/{id}")
	public Book findOne(@PathVariable String id) {
		return bookService.findById(id);
	}
	
	@RequestMapping("/findbyname/{name}")
	public Page<Book> findByName(@PathVariable String name) {
		return bookService.findByName(name);
	}

}
