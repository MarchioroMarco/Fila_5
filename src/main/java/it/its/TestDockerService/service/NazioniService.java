package it.its.TestDockerService.service;

import java.util.List;

import it.its.TestDockerService.dao.NazioniDao;
import it.its.TestDockerService.dto.NazioniDto;


public interface NazioniService {

public List <NazioniDao> selTutti();
	
	public List<NazioniDto> parseDto();
}