package br.com.etechoracio.platpet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Pagamento> findAll() {
		return dao.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Pagamento> findById(@PathVariable Integer id){
		return dao.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Pagamento> update(@PathVariable("id") Integer id,
											@RequestBody Pagamento pag){
		return dao.findById(id)
			.map(record -> {
				record.setDescpagamento(pag.getDescpagamento());
				Pagamento updated = dao.save(record);
				return ResponseEntity.ok().body(updated);
			}).orElse(ResponseEntity.notFound().build());
	}
	
	
	@DeleteMapping(path= {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return dao.findById(id)
				.map(record -> {
					dao.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	

	
	
	
}
	
