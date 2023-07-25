package br.com.bookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bookservice.model.Book;
import br.com.bookservice.proxy.CambioProxy;
import br.com.bookservice.repository.BookRepository;

@RestController
@RequestMapping("book-service")
public class BookController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CambioProxy cambioProxy;
	
	@GetMapping(value = "/{id}/{currency}")
	public Book findBook(@PathVariable("id")Long id,@PathVariable("currency")String currency) {
		var book = repository.getById(id);
		if(book == null) throw new RuntimeException("Book not found");
		
		
		var cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);
		
		var port = environment.getProperty("local.server.port");
		book.setEnviroment("Book port: "+port+" Cambio port"+cambio.getEnvironment());
		book.setPrice(cambio.getConvertedvalue());
		return book;
	}
	
}
