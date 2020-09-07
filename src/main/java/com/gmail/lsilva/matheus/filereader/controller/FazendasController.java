package com.gmail.lsilva.matheus.filereader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.gmail.lsilva.matheus.filereader.service.FazendasService;

@Controller
@RequestMapping("/fazendas")
public class FazendasController {
	
	@Autowired
	private FazendasService fazendasService;
	
	@RequestMapping
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaFazendas");
		mv.addObject("listaFazendas", fazendasService.listar());
		return mv;
	}
}
