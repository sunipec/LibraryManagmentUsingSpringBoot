package com.springBoot.LMS.springbootLMS.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springBoot.LMS.springbootLMS.Entity.Book;
import com.springBoot.LMS.springbootLMS.Payload.BookDTO;
import com.springBoot.LMS.springbootLMS.Repository.BookRepository;
import com.springBoot.LMS.springbootLMS.Service.BookService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepo;

	public BookServiceImpl(BookRepository bookRepo) {

		this.bookRepo = bookRepo;
	}

	public Book getFromDTO(BookDTO bookDto) {
		Book book = new Book();
		book.setBid(bookDto.getBid());
		book.setBname(bookDto.getBname());
		book.setAuthor(bookDto.getAuthor());
		book.setCost(bookDto.getCost());

		return book;
	}

	public BookDTO getFromEntity(Book book) {
		BookDTO bookDto = new BookDTO();
		bookDto.setBid(book.getBid());
		bookDto.setBname(book.getBname());
		bookDto.setAuthor(book.getAuthor());
		bookDto.setCost(book.getCost());

		return bookDto;
	}

	public BookDTO addBook(BookDTO bookDto) {
		Book book = getFromDTO(bookDto);

		Book newbook = bookRepo.save(book);

		BookDTO bookDtonew = getFromEntity(newbook);
		
		return bookDtonew;
	}

	@Override
	public void deleteBook(int id) {

		bookRepo.deleteById(id);

	}

	@Override
	public BookDTO viewBookById(int id) {

		Book book = bookRepo.getById(id);
		BookDTO newBookDto = getFromEntity(book);
		return newBookDto;
	}

	@Override
	public List<BookDTO> viewBooks() {

		List<Book> book = bookRepo.findAll();
		List<BookDTO> bookdto = new ArrayList<BookDTO>();
		for (Book book1 : book) {
			BookDTO bdo = new BookDTO();
			bdo.setBid(book1.getBid());
			bdo.setBname(book1.getBname());
			bdo.setAuthor(book1.getAuthor());
			bdo.setCost(book1.getCost());
			bookdto.add(bdo);
		}
		return bookdto;

	}

	@Override
	public BookDTO updateBook(int id,BookDTO bookDto) {
//	
		Book book1 = bookRepo.findById(id).orElse(null);
		
		if(book1!=null) {
			//Book book2=new Book();
			book1.setAuthor(bookDto.getAuthor());
			book1.setBname(bookDto.getBname());
			Book save = bookRepo.save(book1);
			BookDTO newDto = getFromEntity(save);
			return newDto;
		}
		else {
			throw new EntityNotFoundException("Book with respected Id not found");
			
		}
		
		
	}

}
