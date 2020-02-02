package it.its.TestDockerService.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.TestDockerService.dao.DipendentiDao;
import it.its.TestDockerService.repository.DipendentiRepository;
@Service
@Transactional

public class DipendentiServiceImpl implements DipendentiService{
	
	@Autowired
	DipendentiRepository dipendentiRepository;

	@Override
	public List<DipendentiDao> selTutti() {
		
		return dipendentiRepository.findAll();
	}
	
	@Override
	public Optional<DipendentiDao> selById(Long id) {
		return dipendentiRepository.findById(id);
	}

	@Override
	public void delDip(Long id) {
		dipendentiRepository.deleteById(id);
		
	}
	
	

}
