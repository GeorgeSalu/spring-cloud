package br.com.cambioservice.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cambioservice.model.Cambio;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

	@GetMapping(value = "/{amount}/{from}/{to}")
	private Cambio getCambio(@PathVariable("amount") BigDecimal amout,@PathVariable("from")String from,@PathVariable("to")String to) {
		return new Cambio(1L, from, to , BigDecimal.ONE, BigDecimal.ONE, "PORT 8000");
	}
	
}
