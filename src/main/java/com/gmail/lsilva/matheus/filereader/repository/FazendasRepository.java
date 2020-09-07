package com.gmail.lsilva.matheus.filereader.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.lsilva.matheus.filereader.model.Fazendas;

public interface FazendasRepository extends  JpaRepository<Fazendas, Long>{
	
	Fazendas findByCar(String car);
}
