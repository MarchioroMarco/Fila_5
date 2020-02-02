package it.its.TestDockerService.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
	
	@GetMapping(value = "/id/{id}", produces = "application/json")
	public Optional<DipendentiDao> listDipById(@PathVariable("id") Long id) 
			 
	{
		LOGGER.info("****** Otteniamo il dip con Id: " + id + "*******");
		
		Optional<DipendentiDao> dip = dipendentiService.selById(id);
		
		if (dip == null)
		{
			LOGGER.info("DIPENDENTE NON TROVATO");
		}
		
		return dip;
		
	}
	
	
	
	@DeleteMapping(value = "/elimina/{idDip}")
	public ResponseEntity<?> deleteDip(@PathVariable("id") Long id) 
	{
		LOGGER.info("Eliminiamo il dipendente con id " + id);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		
		Optional<DipendentiDao> dipendenti = dipendentiService.selById(id);
		
		if (dipendenti == null)
		{
			LOGGER.warn("Impossibile trovare la promo con id " + id);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		dipendentiService.delDip(id);
		
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", "Eliminazione Dipendente " + id + " Eseguita Con Successo!");
		
		return new ResponseEntity<>(responseNode, headers, HttpStatus.OK);
	}
	

}
