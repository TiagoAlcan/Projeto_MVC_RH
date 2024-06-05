package com.github.tiagoalcan.mvc_rh.controller;

import java.util.List;
import java.util.Optional;

import com.github.tiagoalcan.mvc_rh.controller.dto.FormCargo;
import com.github.tiagoalcan.mvc_rh.lov.ListOfValueBuilder;
import com.github.tiagoalcan.mvc_rh.model.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.github.tiagoalcan.mvc_rh.model.Cargo;
import com.github.tiagoalcan.mvc_rh.repository.CargoRepository;
import com.github.tiagoalcan.mvc_rh.repository.DepartamentoRepository;


@Controller
@RequestMapping("cargos")
public class CargoController {

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Autowired
	private ListOfValueBuilder listOfValueBuilder;

	@GetMapping()
	public String list(Model model) {
		List<Cargo> cargos = cargoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		model.addAttribute("cargos", cargos);
		return "cargo/list";
	}

	@GetMapping("add")
	public String create(Model model) {
		model.addAttribute("cargo", new FormCargo());
		model.addAttribute("lovDepartamentos", listOfValueBuilder.getLovCargos());
		return "cargo/form";
	}

	@PostMapping("save")
	public String save(@ModelAttribute FormCargo cargo) {

		Departamento departamento = Optional.ofNullable(cargo.getIdDepartamento())
				.map(id_departamento ->  departamentoRepository.getReferenceById(id_departamento))
				.orElse(null);

		cargoRepository.save(cargo.toModel(departamento));

		return "redirect:/cargos";
	}

	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model) {
		Cargo cargo = cargoRepository.findById(id).orElse(new Cargo());

		model.addAttribute("cargo", new FormCargo().toForm(cargo));
		model.addAttribute("lovDepartamentos", listOfValueBuilder.getLovCargos());

		return "cargo/form";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		cargoRepository.deleteById(id);
		return "redirect:/cargos";
	}

}