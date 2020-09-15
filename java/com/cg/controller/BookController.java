package com.cg.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Book;
import com.cg.model.Library;
import com.cg.service.BookService;

@RestController
public class BookController {

	@Autowired BookService bookService;
	
     @PostMapping("/home")
     public String addBook(@ModelAttribute("book") Book book,@ModelAttribute("library")Library library) {
    	   book.setLibrary(library);
    	   bookService.insertBook(book);
           return "index.jsp"; 
     }

     @GetMapping("/find/{bookId}")
     public String findBook(@PathVariable String bookId)
     {
    	 bookService.findBook(bookId);
    	 return "find.jsp";
     }
     
     @GetMapping("/delete/{bookId}")
     public String deleteBook(@PathVariable String bookId) {
           bookService.deleteBook(bookId);
           return "index.jsp";  
     }

     @GetMapping("/update/{bookId}")
     public String editEmployee(@PathVariable String bookId, @PathVariable String bookName,
 			@PathVariable String author, @PathVariable String publisher) {
           bookService.updateBook(bookId, bookName, author, publisher);
           return "update.jsp";
     }

	
	

}