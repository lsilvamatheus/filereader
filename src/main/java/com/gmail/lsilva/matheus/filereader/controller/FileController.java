package com.gmail.lsilva.matheus.filereader.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.gmail.lsilva.matheus.filereader.service.FileService;

@Controller
@RequestMapping("/arquivos")
public class FileController {

	@Autowired
	private FileService fileService;

	@Autowired

	@RequestMapping
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaArquivos");
		try {
			mv.addObject("files", fileService.listar());
		} catch (IOException e) {
			throw new IllegalArgumentException("Erro ao buscar arquivos: " + e.getMessage());
		}
		return mv;
	}

	@RequestMapping("/processar")
	public String processarArquivos(RedirectAttributes attributes) throws IOException {
		String mensagem = fileService.processarArquivos();
		if (mensagem.isEmpty()) {
			attributes.addFlashAttribute("mensagem", "Processamento dos arquivos realizado com sucesso.");
			return "redirect:/arquivos";
		} else {
			attributes.addFlashAttribute("mensagemErro", mensagem);
			return "redirect:/arquivos";
		}
	}

}
