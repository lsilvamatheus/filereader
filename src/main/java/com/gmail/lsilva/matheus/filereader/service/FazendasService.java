package com.gmail.lsilva.matheus.filereader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.gmail.lsilva.matheus.filereader.model.Fazendas;
import com.gmail.lsilva.matheus.filereader.repository.FazendasRepository;

@Service
public class FazendasService {
	
	@Autowired
	private FazendasRepository fazendasRepository;
	
	public List<Fazendas> listar(){
			return fazendasRepository.findAll();
	}
	
	public void salvar(Fazendas fazendas) throws Exception {
		try {
			fazendasRepository.save(fazendas);
		} catch (Exception e) {
			throw new Exception("Erro ao salvar fazenda: - " + e.getMessage());
		}
	}

}
