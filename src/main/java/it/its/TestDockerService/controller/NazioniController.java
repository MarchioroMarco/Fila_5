package it.its.TestDockerService.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.its.TestDockerService.dto.BaseResponseDto;
import it.its.TestDockerService.dto.NazioniDto;
import it.its.TestDockerService.service.NazioniService;

@RestController
@RequestMapping(value = "api/nazioni")
public class NazioniController {

	@Autowired
	private NazioniService nazioniService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DipendentiController.class);
	
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<NazioniDto>> fetchAll(){
		
		BaseResponseDto<List<NazioniDto>> response = new BaseResponseDto<>();
		LOGGER.info("******Otteniamo tutto******");
		
		List<NazioniDto> nazioni = nazioniService.parseDto();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessagge("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		if(nazioni.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		LOGGER.info("Numero dei record: " + nazioni.size());
		
		response.setResponse(nazioni);
		return response;
		
	}
	
	@GetMapping(value= "/all", produces = "application/json")
	public HttpStatus tutte(){
		
		HttpStatus response = nazioniService.all();
		return response;
		
	}
	
	@GetMapping(value= "/name/{name}", produces = "application/json")
	public HttpStatus name(@PathVariable("name") String s){
		
		HttpStatus response = nazioniService.name(s);
		return response;
		
	}
	
	
}
