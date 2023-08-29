package com.springBoot.LMS.springbootLMS.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springBoot.LMS.springbootLMS.Payload.BookDTO;

public interface BookService {

	BookDTO addBook(BookDTO bookDto);
	
	void deleteBook(int id);
	
	BookDTO viewBookById(int id);
	
	List<BookDTO> viewBooks();
	
	BookDTO updateBook(int id,BookDTO bookDto); 
}
