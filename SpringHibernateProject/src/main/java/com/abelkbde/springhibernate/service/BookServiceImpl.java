package com.abelkbde.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abelkbde.springhibernate.dao.BookDao;
import com.abelkbde.springhibernate.model.Book;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao dao;
	
	@Override
	public void saveBook(Book book) {
		dao.saveBook(book);
		
	}
	
	@Override
	public List<Book> findAllBooks() {
		return dao.findAllBooks();
	}

	@Override
	public void deleteBookByTitle(String title) {
		dao.deleteBookByTitle(title);
		
	}

	@Override
	public Book findByByTitle(String title) {
		return dao.findBookByTitle(title);
	}

	@Override
	public void updateBook(Book book) {
		dao.updateBook(book);
		
	}

}
