package com.abelkbde.springhibernate.configuration;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.abelkbde.springhibernate.model.Book;
import com.abelkbde.springhibernate.service.BookService;

public class AppMain {

	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		BookService service = (BookService) context.getBean("bookService");
		
		/*
		 * Create book1
		 */
		Book book1 = new Book();
		book1.setTitle("The God Father");
		book1.setAuthor("Mario Puzo");
				
		/*
		 * Create book2
		 */
		Book book2 = new Book();
		book2.setTitle("Atlas Shrugged");
		book2.setAuthor("Ayn Rand");
				
		/*
		 * Create book3
		 */
		Book book3 = new Book();
		book3.setTitle("Crime And Punishment");
		book3.setAuthor("Fyodor Dostoevsky");
		
		/*
		 * Create book4
		 */
		Book book4 = new Book();
		book4.setTitle("War And Peace");
		book4.setAuthor("Leo Tolstoy");
		

		/*
		 * Persist all Books
		 */
		service.saveBook(book1);
		service.saveBook(book2);
		service.saveBook(book3);
		service.saveBook(book4);

		/*
		 * Get all employees list from database
		 */
		List<Book> books = service.findAllBooks();
		for (Book book : books) {
			System.out.println(book);
		}

		/*
		 * delete a book
		 */
		service.deleteBookByTitle("The God Father");

		/*
		 * update a book
		 */
		Book book = service.findByByTitle("Atlas Shrugged");
		book.setAuthor("Ayn Raand");
		service.updateBook(book);

		/*
		 * Get all books list from database
		 */
		List<Book> bookList = service.findAllBooks();
		for (Book currentBook : bookList) {
			System.out.println(currentBook);
		}

		context.close();
	}
}
