package it.its.TestDockerService.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "utenti")
@Data
public class UtentiDao {
	
	@Id
	@Column(name = "id")
	private int id ;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "passw")
	private String password;

}
