package br.com.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.model.Van;
import br.com.teste.service.VanServices;

@RestController
@RequestMapping("/vans")
// notation que permite que os endpoints sejam acionados pelo React
@CrossOrigin(origins = "http://localhost:3000")
public class VansController {
	
	@Autowired
	private VanServices service;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Van> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Van findOne(@PathVariable(value = "id") Long id) throws Exception {
		return service.findById(id);
	}
	
	@GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Van> findByFilter(@RequestParam(value = "filter") String filter) {
	    return service.findByFilter(filter);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Van update(@RequestBody Van van) {
		return service.update(van);
	}
	
	/* Métodos desabilitados pois o objetivo da API é fornecer os dados
	 * para montagem do site e deisposição das vans
	 * 
	 * @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Van create(@RequestBody Van van) {
		return service.create(van);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Van update(@RequestBody Van van) {
		return service.update(van);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) throws Exception {
		service.delete(id);
	}*/
	
}
