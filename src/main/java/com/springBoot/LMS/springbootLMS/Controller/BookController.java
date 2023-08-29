package com.springBoot.LMS.springbootLMS.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.LMS.springbootLMS.Entity.Book;
import com.springBoot.LMS.springbootLMS.Payload.BookDTO;
import com.springBoot.LMS.springbootLMS.Service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {

	private BookService bookService;
	
	
	
	
	public BookController(BookService bookService) {
		
		this.bookService = bookService;
	}




	@PostMapping("/addbook")
	public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDto){
		return new ResponseEntity<BookDTO>(bookService.addBook(bookDto),HttpStatus.CREATED);
	}
	
	@PostMapping("/deletebook/{bid}")
	public void DeleteBook(@PathVariable("bid")  int bid) {
		 bookService.deleteBook(bid);
		
	}
	
	@GetMapping("/viewbook/{bid}")
	public BookDTO viewBookById(@PathVariable("bid") int bid) {
		return bookService.viewBookById(bid);
	}
	
	@GetMapping("/viewallbook")
	public List<BookDTO> viewBooks() {
		return bookService.viewBooks();
	}
	
	@PutMapping("/update/{bid}")
	public ResponseEntity<BookDTO> updateBook(@PathVariable("bid") int bid ,@RequestBody BookDTO bookDto) {
		 BookDTO bookDto1 =bookService.updateBook(bid,bookDto);
		 return ResponseEntity.ok(bookDto1);
		
	}
	
}
