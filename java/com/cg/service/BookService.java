package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Book;
import com.cg.repository.BookRepository;

@Service
public class BookService {

	@Autowired BookRepository bookRepo;
	
	public void insertBook(Book book)
	{
		bookRepo.save(book);
	}

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		  List<Book> list = bookRepo.findAll();
		  return list;
	}

	public Book updateBook(String bookId,String bookName,String author,String publisher) {
		// TODO Auto-generated method stub
       Book book = bookRepo.getOne(bookId);
       book.setAuthor(author);
       book.setBookId(bookId);
       book.setBookName(bookName);
       book.setPublisher(publisher);
       bookRepo.save(book);
       return book;
  }

	public void deleteBook(String bookId) {
		// TODO Auto-generated method stub
		bookRepo.deleteById(bookId);
	}

	public Book findBook(String bookId) {
		// TODO Auto-generated method stub
		Book book =bookRepo.getOne(bookId);
		return book;
	}
	
}
