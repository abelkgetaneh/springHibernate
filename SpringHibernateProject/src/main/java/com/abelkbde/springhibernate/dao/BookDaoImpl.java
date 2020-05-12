package com.abelkbde.springhibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.abelkbde.springhibernate.model.Book;

@Repository("bookDao")
public class BookDaoImpl extends AbstractDao implements BookDao{

	@Override
	public void saveBook(Book book) {
		persist(book);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAllBooks() {
		Criteria criteria = getSession().createCriteria(Book.class);
		return (List<Book>)criteria.list();
	}

	@Override
	public void deleteBookByTitle(String title) {
		Query query = getSession().createSQLQuery("delete from Book where title = :title");
		query.setString("title", title);
		query.executeUpdate();
		
	}

	@Override
	public Book findBookByTitle(String title) {
		Criteria criteria = getSession().createCriteria(Book.class);
		criteria.add(Restrictions.eq("title", title));
		return (Book) criteria.uniqueResult();
	}

	@Override
	public void updateBook(Book book) {
		getSession().update(book);
		
	}

}
