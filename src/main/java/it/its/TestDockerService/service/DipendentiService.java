package it.its.TestDockerService.service;

import java.util.List;
import java.util.Optional;

import com.sun.xml.bind.v2.model.core.ID;

import it.its.TestDockerService.dao.DipendentiDao;

public interface DipendentiService {

	public List <DipendentiDao> selTutti();
	
	public Optional<DipendentiDao> selById(Long id);
}
