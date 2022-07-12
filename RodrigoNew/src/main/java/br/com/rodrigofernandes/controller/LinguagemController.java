package br.com.rodrigofernandes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.rodrigofernandes.model.LinguagensFramworks;
import br.com.rodrigofernandes.service.LinguagemService;

@Controller
@RequestMapping("/linguagem")
public class LinguagemController {
	
	@Autowired
	private LinguagemService lService;
	
	/*@RequestMapping("/novo")
	public String novo() {
		return "CadastroEmpresa";
	}**/
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String salvar(LinguagensFramworks linguagem) {
		lService.save(linguagem);
		return "redirect:/linguagem/listar";
	}
	
	@RequestMapping("listar")
	public String home(Model model) {
		List<LinguagensFramworks> listaLinguagens = lService.todos();
		model.addAttribute("listaLinguagem", listaLinguagens);
		return "linguagens";
	}
	
	@RequestMapping("adicionar")
	public ModelAndView add(LinguagensFramworks linguagem) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cadastrolinguagem");
		mv.addObject("linguagem",linguagem);//"empresas é o object da view
		
		return mv;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		lService.excluirLinguagem(id);
		
		ModelAndView mv = new ModelAndView("redirect:/linguagem/listar");
		
		return mv;
	}
	
	@RequestMapping("editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		return add(lService.buscarLinguagem(id));
	}

}
