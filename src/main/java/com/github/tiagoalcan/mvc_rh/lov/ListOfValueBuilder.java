package com.github.tiagoalcan.mvc_rh.lov;

import com.github.tiagoalcan.mvc_rh.repository.CargoRepository;
import com.github.tiagoalcan.mvc_rh.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListOfValueBuilder {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Autowired
	private CargoRepository cargoRepository;

	public List<ListOfValue> getLovDepartamentos() {			
		return departamentoRepository
				.findAll(Sort.by(Sort.Direction.ASC, "nome"))
				.stream()
				.map(d -> new ListOfValue(d.getId(), d.getNome()))
				.toList();
	}

	public List<ListOfValue> getLovCargos() {
		return cargoRepository
				.findAll(Sort.by(Sort.Direction.ASC, "nome"))
				.stream()
				.map(c -> new ListOfValue(c.getId(), c.getNome()))
				.toList();
	}

}
