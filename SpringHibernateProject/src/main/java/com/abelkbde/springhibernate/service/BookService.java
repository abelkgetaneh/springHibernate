package com.abelkbde.springhibernate.service;

import java.util.List;

import com.abelkbde.springhibernate.model.Book;

public interface BookService {
	 
    void saveBook(Book book);
 
    List<Book> findAllBooks();
 
    void deleteBookByTitle(String title);
 
    Book findByByTitle(String title);
 
    void updateBook(Book Book);
}
