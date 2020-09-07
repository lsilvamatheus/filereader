package com.gmail.lsilva.matheus.filereader.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class FileDTO {
	
	private int numero;
	private String name;
	private Long size;	
}
