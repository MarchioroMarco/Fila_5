package it.its.TestDockerService.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
			criptaPass(d);
			dto.add(new UtentiDto(d.getId(),d.getUsername(),d.getPassword(), d.getRuolo()));
		}
		return dto;
	}



	@Override
	public void insUtente(UtentiDao u) {
		utentiRepository.saveAndFlush(u);
		
	}

	@Override
	public boolean verificaUsername(String username) {
		List<UtentiDto> dto = parseDto();
		for(UtentiDto d : dto) {
			if(d.getUsername().equals(username)) {
				return true;
		}
	  }
		
		return false;
	}

	@Override
	public boolean verificaPassword(String password) {
		//List<UtentiDto> dto = parseDto();
		//for(UtentiDto d : dto) {
			if(password.equals("root")) {
				return true;
		}else {
			return false;
		}
	  //}
		
		
	}

	@Override
	public void criptaPass(UtentiDao u) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(u.getPassword());
		u.setPassword(encodedPassword);
		
	}


		
	


}
