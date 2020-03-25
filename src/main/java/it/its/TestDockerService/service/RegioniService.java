package it.its.TestDockerService.service;

import java.util.List;

import it.its.TestDockerService.dao.RegioniDao;
import it.its.TestDockerService.dto.RegioniDto;


public interface RegioniService {

public List <RegioniDao> selTutti();
	
	public List<RegioniDto> parseDto();
}
