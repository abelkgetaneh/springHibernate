package com.abelkbde.springhibernate.dao;

import java.util.List;

import com.abelkbde.springhibernate.model.Book;

public interface BookDao {

	void saveBook(Book book);
	
	List<Book> findAllBooks();
	
	void deleteBookByTitle(String title);
	
	Book findBookByTitle(String title);
	
	void updateBook(Book book);
}
