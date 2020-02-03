package it.its.TestDockerService.service;

import java.util.List;

import it.its.TestDockerService.dao.ProvinceDao;
import it.its.TestDockerService.dto.ProvinceDto;


public interface ProvinceService {

public List <ProvinceDao> selTutti();
	
	public List<ProvinceDto> parseDto();
}
