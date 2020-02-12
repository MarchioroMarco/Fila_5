package it.its.TestDockerService.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.TestDockerService.dao.UtentiDao;
import it.its.TestDockerService.dto.UtentiDto;
import it.its.TestDockerService.repository.UtentiRepository;
import lombok.extern.java.Log;
////
@Service
@Transactional
public class UtentiServiceImpl implements UtentiService{

	@Autowired
	UtentiRepository utentiRepository;
	
	@Override
	public List<UtentiDao> selTutti() {
		return utentiRepository.findAll();
	}

	@Override
	public List<UtentiDto> parseDto() {
		List<UtentiDto> dto = new ArrayList<UtentiDto>();
		List<UtentiDao> dao = this.selTutti();
		for (UtentiDao d : dao) {
			dto.add(new UtentiDto(d.getId(),d.getUsername(),d.getPassword()));
		}
		return dto;
	}

	@Override
	public boolean verificaUtente(UtentiDto o) {
		List<UtentiDto> dto = parseDto();
		for(UtentiDto d : dto) {
			if(d.getUsername().equals(o.getUsername())&& d.getPassword().equals(o.getPassword())) {
				return true;
		}
	  }
		
		return false;
	}

	@Override
	public void insUtente(UtentiDao u) {
		utentiRepository.saveAndFlush(u);
		
	}

}
