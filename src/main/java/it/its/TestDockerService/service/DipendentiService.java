package it.its.TestDockerService.service;

import java.util.List;
import java.util.Optional;

import com.sun.xml.bind.v2.model.core.ID;

import it.its.TestDockerService.dao.DipendentiDao;
import it.its.TestDockerService.dto.DipendentiDto;

public interface DipendentiService {

	public List <DipendentiDao> selTutti();
	
	public List<DipendentiDto> parseDto();
	
	public Optional<DipendentiDao> selById(Long id);
	
	public void delDip(Long id);

	public void insDip(DipendentiDao dip);
}
