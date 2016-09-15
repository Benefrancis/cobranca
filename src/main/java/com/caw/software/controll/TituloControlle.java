package com.caw.software.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.caw.software.model.StatusTitulo;
import com.caw.software.model.Titulo;
import com.caw.software.repository.TituloRepository;

@Controller
public class TituloControlle {

	@Autowired
	private TituloRepository tituoRepository;

	@RequestMapping("/titulos")
	public ModelAndView index(Titulo titulo) {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("todoStatusTitulo", StatusTitulo.values());
		return mv;
	}

	@RequestMapping(value = "/titulos/novo", method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		tituoRepository.save(titulo);
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem", "Titulo salvo com sucesso");
		return mv;
	}
}