package it.its.TestDockerService.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.TestDockerService.dao.CittaDao;
import it.its.TestDockerService.dto.CittaDto;
import it.its.TestDockerService.repository.CittaRepository;

@Service
@Transactional
public class CittaServiceImpl implements CittaService{

	@Autowired
	CittaRepository cittaRepository;

	@Override
	public List<CittaDao> selTutti() {
		return cittaRepository.findAll();
	}

	@Override
	public List<CittaDto> parseDto() {
		List<CittaDto> dto = new ArrayList<CittaDto>();
		List<CittaDao> dao = this.selTutti();
		for (CittaDao d : dao) {
			dto.add(new CittaDto(d.getId(),d.getDescrizione()));
		}
		return dto;
	}
}
