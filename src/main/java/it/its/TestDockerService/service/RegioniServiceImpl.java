package it.its.TestDockerService.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.TestDockerService.dao.RegioniDao;
import it.its.TestDockerService.dto.RegioniDto;
import it.its.TestDockerService.repository.RegioniRepository;

@Service
@Transactional
public class RegioniServiceImpl implements RegioniService{

	@Autowired
	RegioniRepository regioniRepository;

	@Override
	public List<RegioniDao> selTutti() {
		return regioniRepository.findAll();
	}

	@Override
	public List<RegioniDto> parseDto() {
		List<RegioniDto> dto = new ArrayList<RegioniDto>();
		List<RegioniDao> dao = this.selTutti();
		for (RegioniDao d : dao) {
			dto.add(new RegioniDto(d.getId(),d.getDescrizione()));
		}
		return dto;
	}
}
