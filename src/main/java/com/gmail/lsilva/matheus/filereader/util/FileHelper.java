package com.gmail.lsilva.matheus.filereader.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileHelper {
	
	@Value("${pathDiretorioArquivos}")
	private String pathDiretorioArquivos;
	
	public List<File> getDirectoryFiles(){
		File file = new File(pathDiretorioArquivos);
		return Arrays.asList(file.listFiles());
	}

}
