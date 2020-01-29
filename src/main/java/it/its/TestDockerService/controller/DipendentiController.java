package it.its.TestDockerService.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.its.TestDockerService.dao.DipendentiDao;
import it.its.TestDockerService.dto.BaseResponseDto;
import it.its.TestDockerService.dto.DipendentiDto;
import it.its.TestDockerService.service.DipendentiService;

@RestController
@RequestMapping(value = "api/dipendenti")
//pushatelo raga
public class DipendentiController {
	
	@Autowired
	private DipendentiService dipendentiService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DipendentiController.class);
	
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<DipendentiDto>> fetchAll(){
		
		BaseResponseDto<List<DipendentiDto>> response = new BaseResponseDto<>();
		LOGGER.info("******Otteniamo tutto******");
		
		List<DipendentiDao> dipendenti = dipendentiService.selTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessagge("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		if(dipendenti.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		LOGGER.info("Numero dei record: " + dipendenti.size());
		
		DipendentiDto dto = new DipendentiDto();
		dto.setDipendentiData(dipendenti);
		response.setResponse(dto);
		return response;
		
	}
	

}
