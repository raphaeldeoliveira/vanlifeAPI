package br.com.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.model.Van;

public interface VanRepository extends JpaRepository<Van, Long> {

}
