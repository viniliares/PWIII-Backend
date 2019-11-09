package br.com.etechoracio.platpet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.etechoracio.platpet.DAO.PagamentoDAO;
import br.com.etechoracio.platpet.model.Pagamento;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	private PagamentoDAO dao;
	
	@PostMapping
	public void insert(@RequestBody Pagamento pag) {
		dao.save(pag);
	}
	
	@GetMapping
	public void select(@RequestBody Pagamento pag) {
		dao.findAll();
	}
	
	@PutMapping
	public void update(@RequestBody Pagamento pag) {
		dao.findById(pag.getId());
	}

}
