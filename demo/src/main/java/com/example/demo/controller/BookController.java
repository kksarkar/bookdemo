package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.entity.Response;
import com.example.demo.repo.BookRepository;

@RestController
public class BookController {

	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/getBooks")
	public List<Book> helloWorld()
	{
		return bookRepository.findAll();
	}
	
	@PostMapping("/saveBook")
	public Response saveBook(@RequestBody Book book)
	{
		Response response = new Response();
		
		bookRepository.save(book);
		
		response.setStatus(200);
		response.setMessage("Sucessfully");
		
		return response;
	}
}
