package com.github.tiagoalcan.mvc_rh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.tiagoalcan.mvc_rh.model.Funcionario;
import com.github.tiagoalcan.mvc_rh.repository.FuncionarioRepository;

@Controller
@RequestMapping("funcionarios")
public class FuncionarioController {

	//@GetMapping vazio para trazer lista é uma boa prática(tela inicial)
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping()
	public String list(Model model) {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		model.addAttribute("nome_funcionarios", funcionarios);
		return "funcionario/list";
	}
	
	//redirect redireciona para funcionarios - o acima - porque ele que completa a lista. 
	//Se chamar a lista direto não completamos a lista, apenas chamamos o HTMl.
	@PostMapping("save")
	public String save(@ModelAttribute Funcionario funcionario) {
		System.out.println(funcionario.getId());
		System.out.println(funcionario.getNome());
		
		return "redirect:/funcionarios";
	}
	
	@GetMapping("add")
	public String create(Model model) {
		model.addAttribute("funcionario", new Funcionario());
		return "funcionario/form";
	}
}