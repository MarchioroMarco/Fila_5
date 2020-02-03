package it.its.TestDockerService.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.TestDockerService.dao.NazioniDao;
import it.its.TestDockerService.dto.NazioniDto;
import it.its.TestDockerService.repository.NazioniRepository;

@Service
@Transactional
public class NazioniServiceImpl implements NazioniService{

	@Autowired
	NazioniRepository nazioniRepository;

	@Override
	public List<NazioniDao> selTutti() {
		return nazioniRepository.findAll();
	}

	@Override
	public List<NazioniDto> parseDto() {
		List<NazioniDto> dto = new ArrayList<NazioniDto>();
		List<NazioniDao> dao = this.selTutti();
		for (NazioniDao d : dao) {
			dto.add(new NazioniDto(d.getIso(),d.getDescrizione()));
		}
		return dto;
	}
}
