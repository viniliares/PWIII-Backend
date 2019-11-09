package br.com.etechoracio.platpet.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.platpet.model.Pagamento;

public interface PagamentoDAO extends 	JpaRepository<Pagamento, Integer> {
	

	
}