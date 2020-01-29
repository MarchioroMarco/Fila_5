package it.its.TestDockerService.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "dipendenti")
@Data
public class DipendentiDao{

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "tax_code")
	private String tax_code;
	
	@Column(name = "indirizzo")
	private String indirizzo;
	
	@Column(name = "sesso")
	private String sesso;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telefono")
	private String telefono;
	
	
}
