package it.its.TestDockerService.dto;

import java.util.List;

import it.its.TestDockerService.dao.DipendentiDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DipendentiDto {
	//NON CI DEVE ESSERE 
//	private List<DipendentiDao> dipendentiData;
	
	private Long id;
	private String nome;
	private String cognome;
	private String tax_code;
	private String indirizzo;
	private String sesso;
	private String email;
	private String telefono;
}
