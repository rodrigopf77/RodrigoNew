package br.com.rodrigofernandes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.rodrigofernandes.model.Produto;
import br.com.rodrigofernandes.model.Empresa;
import br.com.rodrigofernandes.service.CursoService;
import br.com.rodrigofernandes.service.EmpresaService;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoService cService;
	@Autowired
	private EmpresaService eService;
	
	@RequestMapping("adicionar")
	public ModelAndView addCurso(Produto curso) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cadastrocurso");
		mv.addObject("curso", curso);
		
		List<Empresa> empresas = eService.todos();
		mv.addObject("lista_empresa", empresas);
		
		return mv;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String salvar(Produto curso) {
		cService.save(curso);
		return "redirect:/curso/listar";
	}
	
	@RequestMapping("listar")
	public String home(Model model) {
		List<Produto> listaCursos = cService.todos();
		model.addAttribute("listaCurso", listaCursos);
		return "cursos";
	}
	
	@RequestMapping("editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		return addCurso(cService.buscarCurso(id));
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		cService.excluirCurso(id);
		
		ModelAndView mv = new ModelAndView("redirect:/curso/listar");
		
		return mv;
	}
	
}
