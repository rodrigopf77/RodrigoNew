package br.com.rodrigofernandes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.rodrigofernandes.model.Empresa;
import br.com.rodrigofernandes.model.Formacao;
import br.com.rodrigofernandes.model.Produto;
import br.com.rodrigofernandes.service.CursoService;
import br.com.rodrigofernandes.service.EmpresaService;
import br.com.rodrigofernandes.service.FormacaoService;

@Controller
@RequestMapping("/formacao")
public class FormacaoController {
		
		@Autowired
		private FormacaoService fService;
		@Autowired
		private EmpresaService eService;
		@Autowired
		private CursoService cService;
		
		@RequestMapping("adicionar")
		public ModelAndView addCurso(Formacao formacao) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("cadastrarformacao");
			mv.addObject("formacao", formacao);

			List<Empresa> empresas = eService.todos();
			mv.addObject("lista_empresa", empresas);

			return mv;
		}
		
		@RequestMapping(value = "save", method = RequestMethod.POST)
		public String salvar(Formacao formacao) {
			fService.save(formacao);
			return "redirect:/formacao/listar";
		}
		
		@RequestMapping("listar")
		public String home(Model model) {
			List<Formacao> listaFormacao = fService.todos();
			List<Produto> listaCursos = cService.todos(); 
			
			model.addAttribute("listaFormacao", listaFormacao);
			model.addAttribute("listaCurso", listaCursos);
			
			return "formacao";
		}
		
		@RequestMapping("editar/{id}")
		public ModelAndView editar(@PathVariable("id") Long id) {
			return addCurso(cService.buscarCurso(id));
		}
		
		@RequestMapping("/delete/{id}")
		public ModelAndView delete(@PathVariable("id") Long id) {
			fService.excluirFormacao(id);
			
			ModelAndView mv = new ModelAndView("redirect:/formacao/listar");
			
			return mv;
		}

}
