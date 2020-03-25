package it.its.TestDockerService.service;

import java.util.List;

import it.its.TestDockerService.dao.CittaDao;
import it.its.TestDockerService.dto.CittaDto;


public interface CittaService {

public List <CittaDao> selTutti();
	
	public List<CittaDto> parseDto();
}
