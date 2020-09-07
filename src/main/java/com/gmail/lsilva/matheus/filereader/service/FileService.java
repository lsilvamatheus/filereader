package com.gmail.lsilva.matheus.filereader.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gmail.lsilva.matheus.filereader.model.Fazendas;
import com.gmail.lsilva.matheus.filereader.model.dto.FileDTO;
import com.gmail.lsilva.matheus.filereader.repository.FazendasRepository;
import com.gmail.lsilva.matheus.filereader.util.FileHelper;

@Service
public class FileService {

	@Autowired
	private FileHelper fileHelper;

	@Autowired
	private FazendasRepository fazendasRepository;

	@Autowired
	private List<FileDTO> filesDTO;

	public List<FileDTO> listar() throws IOException {
		limparListDTO();

		int rowNumber = 1;
		for (File f : fileHelper.getDirectoryFiles()) {
			Fazendas fazendas = localizarFazenda(f.getName());
			if (fazendas == null || fazendas.getAnexo() == null) {
				FileDTO fileDTO = new FileDTO();
				fileDTO.setNumero(rowNumber);
				fileDTO.setName(f.getName());
				fileDTO.setSize(f.length());
				filesDTO.add(fileDTO);
			}
			rowNumber++;
		}
		return filesDTO;
	}

	public String processarArquivos() {
		int arquivosProcessados = 0;
		String mensagem = "";
		List<File> files = fileHelper.getDirectoryFiles();
		if (files.isEmpty()) {
			mensagem = "Erro no processamento: Nenhum arquivo salvo no diretório";
		}
		for (File f : files) {
			Fazendas fazendas = localizarFazenda(f.getName());
			if ((fazendas != null) && fazendas.getAnexo() == null) {
				try {
					fazendas.setAnexo(fileGetBytes(f.getPath()));
				} catch (Exception e) {
					mensagem = "Erro ao atualizar registro: " + e.getMessage();
				}
				fazendasRepository.save(fazendas);
				limparListDTO();
				arquivosProcessados++;
			}
			else if(arquivosProcessados == 0)
				mensagem = "Não foram encontrados registros de fazendas para os arquivos da lista. ";
		}
		return mensagem;
	}

	private byte[] fileGetBytes(String path) throws Exception {
		byte[] conteudo = null;
		try {
			conteudo = Files.readAllBytes(Paths.get(path));
		} catch (IOException e) {
			throw new Exception("Erro ao converter arquivo: " + e.getMessage());
		}
		return conteudo;
	}

	private Fazendas localizarFazenda(String nomeArquivo) {
		return fazendasRepository.findByCar(nomeArquivo.replace(".pdf", ""));
	}

	private void limparListDTO() {
		filesDTO.clear();
	}

}
