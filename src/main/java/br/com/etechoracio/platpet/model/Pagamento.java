package br.com.etechoracio.platpet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name="PAGAMENTO")
@Entity
@Setter
@Getter
public class Pagamento {
	
	@Column(name="IDPAGAMENTO")
	@GeneratedValue
	@Id
	private int id;

	@Column(name="DESCPAGAMENTO")
	private String descpagamento;	
}