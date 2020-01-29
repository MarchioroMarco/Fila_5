package it.its.TestDockerService.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "province")
@Data

public class ProvinceDao {

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "descrizione")
	private String descrizione;
}
