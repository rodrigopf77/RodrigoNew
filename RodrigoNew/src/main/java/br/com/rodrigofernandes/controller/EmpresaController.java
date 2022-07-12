package br.com.rodrigofernandes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.rodrigofernandes.model.Empresa;
import br.com.rodrigofernandes.service.EmpresaService;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService eService;
	
	/*@RequestMapping("/novo")
	public String novo() {
		return "CadastroEmpresa";
	}**/
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String salvar(Empresa empresa) {
		eService.save(empresa);
		return "redirect:/empresa/listar";
	}
	
	@RequestMapping("listar")
	public String home(Model model) {
		List<Empresa> listaEmpresas = eService.todos();
		model.addAttribute("listaEmpresa", listaEmpresas);
		return "empresa";
	}
	
	@RequestMapping("adicionar")
	public ModelAndView add(Empresa empresa) {
		System.out.println("Empresa: " + empresa.getNome());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("CadastroEmpresa");
		mv.addObject("empresa",empresa);//"empresas é o object da view
		
		return mv;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		eService.excluirEmpresa(id);
		
		ModelAndView mv = new ModelAndView("redirect:/empresa/listar");
		
		return mv;
	}
	
	@RequestMapping("editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		return add(eService.buscarEmpresa(id));
	}

}
