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

import it.its.TestDockerService.dto.BaseResponseDto;
import it.its.TestDockerService.dto.UtentiDto;
import it.its.TestDockerService.service.UtentiService;

@RestController
@RequestMapping(value = "api/utenti")
public class UtentiController {
	@Autowired
	private UtentiService utentiService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DipendentiController.class);
	
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<UtentiDto>> fetchAll(){
		
		BaseResponseDto<List<UtentiDto>> response = new BaseResponseDto<>();
		LOGGER.info("******Otteniamo tutto******");
		
		List<UtentiDto> utenti = utentiService.parseDto();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessagge("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		if(utenti.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		LOGGER.info("Numero dei record: " + utenti.size());
		
		response.setResponse(utenti);
		return response;
		
	}

}
