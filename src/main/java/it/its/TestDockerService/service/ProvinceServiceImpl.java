package it.its.TestDockerService.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.TestDockerService.dao.ProvinceDao;
import it.its.TestDockerService.dto.ProvinceDto;
import it.its.TestDockerService.repository.ProvinceRepository;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService{

	@Autowired
	ProvinceRepository provinceRepository;

	@Override
	public List<ProvinceDao> selTutti() {
		return provinceRepository.findAll();
	}

	@Override
	public List<ProvinceDto> parseDto() {
		List<ProvinceDto> dto = new ArrayList<ProvinceDto>();
		List<ProvinceDao> dao = this.selTutti();
		for (ProvinceDao d : dao) {
			dto.add(new ProvinceDto(d.getId(),d.getDescrizione()));
		}
		return dto;
	}
}
