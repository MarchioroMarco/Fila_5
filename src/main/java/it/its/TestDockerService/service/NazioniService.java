package it.its.TestDockerService.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import it.its.TestDockerService.dao.NazioniDao;
import it.its.TestDockerService.dto.NazioniDto;


public interface NazioniService {

public List <NazioniDao> selTutti();
	
	public List<NazioniDto> parseDto();
	
	public HttpStatus all();
	
	

	public HttpStatus name(String s);
	
}
