package br.com.teste.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.model.Van;
import br.com.teste.repositories.VanRepository;

@Service
public class VanServices {

	private Logger logger = Logger.getLogger(VanServices.class.getName());
	
	@Autowired
	VanRepository repository;
	
	public List<Van> findAll() {
		logger.info("Finding all vans");

		return repository.findAll();
	}
	
	public Van findById(Long id) {
		logger.info("Finding one van!");
		
		return repository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Mensagem de erro aqui"));
	}
	
	public List<Van> findByFilter(String filter) {
	    logger.info("Finding vans with filtering");

	    List<Van> allVans = repository.findAll();
	    allVans.removeIf(van -> !van.getVanCategory().equals(filter));

	    return allVans;
	}
	
	public Van create(Van van) {
		logger.info("Creating one van!");
		return repository.save(van);
	}
	
	public Van update(Van van) {
		logger.info("Updating one van!");
		
		var entity = repository.findById(van.getId())
				.orElseThrow(() -> new NoSuchElementException("Mensagem de erro aqui"));
		
		entity.setVanName(van.getVanName());
		entity.setVanPrice(van.getVanPrice());
		entity.setTypeLocation(van.getTypeLocation());
		entity.setVanCategory(van.getVanCategory());
		entity.setUrlImage(van.getUrlImage());
		
		return repository.save(van);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one van!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Mensagem de erro aqui"));
		
		repository.delete(entity);
	}
	
}
