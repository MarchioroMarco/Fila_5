package it.its.TestDockerService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.TestDockerService.dao.DipendentiDao;
import it.its.TestDockerService.dto.DipendentiDto;
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

	@Override
	public void insDip(DipendentiDao dip) {
		 dipendentiRepository.saveAndFlush(dip);
		
	}

	@Override
	public List<DipendentiDto> parseDto() {
		List<DipendentiDto> dto = new ArrayList<DipendentiDto>();
		List<DipendentiDao> dao = this.selTutti();
		for (DipendentiDao d : dao) {
			dto.add(new DipendentiDto(d.getId(), d.getNome(), d.getCognome(), d.getTax_code(), d.getIndirizzo(), d.getSesso(), d.getEmail(), d.getTelefono()));
		}
		return dto;
	}

	
	

}
