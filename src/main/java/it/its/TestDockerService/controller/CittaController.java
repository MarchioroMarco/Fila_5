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
import it.its.TestDockerService.dto.CittaDto;
import it.its.TestDockerService.service.CittaService;

@RestController
@RequestMapping(value = "api/citta")
public class CittaController {
	@Autowired
	private CittaService cittaService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DipendentiController.class);
	
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<CittaDto>> fetchAll(){
		
		BaseResponseDto<List<CittaDto>> response = new BaseResponseDto<>();
		LOGGER.info("******Otteniamo tutto******");
		
		List<CittaDto> citta = cittaService.parseDto();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessagge("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		if(citta.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		LOGGER.info("Numero dei record: " + citta.size());
		
		response.setResponse(citta);
		return response;
		
	}

}
