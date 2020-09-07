package com.gmail.lsilva.matheus.filereader.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.DecimalMin;

import lombok.Data;

@Entity
@Data
public class Fazendas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chave;
	private String car;
	private String fazenda;
	private String municipio;
	@DecimalMin(value="1", message="Numero menor que zeero")
	private BigDecimal area;
	
	@Lob
	@Column(name = "anexo")
	private byte[] anexo;	
}
