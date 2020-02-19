package it.its.TestDockerService.service;

import java.util.List;

import it.its.TestDockerService.dao.UtentiDao;
import it.its.TestDockerService.dto.UtentiDto;

public interface UtentiService {

	public List<UtentiDao> selTutti();
	public List<UtentiDto> parseDto();
	public boolean verificaUsername(String username);
	public boolean verificaPassword(String password);
	public void insUtente(UtentiDao u);
	
}
