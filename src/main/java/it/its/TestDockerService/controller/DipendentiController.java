package it.its.TestDockerService.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import it.its.TestDockerService.dao.DipendentiDao;
import it.its.TestDockerService.dto.BaseResponseDto;
import it.its.TestDockerService.dto.DipendentiDto;
import it.its.TestDockerService.service.DipendentiService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/dipendenti")
//pushatelo raga
public class DipendentiController {

	@Autowired
	private DipendentiService dipendentiService;

	private static final Logger LOGGER = LoggerFactory.getLogger(DipendentiController.class);

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<DipendentiDto>> fetchAll() {

		BaseResponseDto<List<DipendentiDto>> response = new BaseResponseDto<>();
		LOGGER.info("******Otteniamo tutto******");

		List<DipendentiDto> dipendenti = dipendentiService.parseDto();

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessagge("SERVIZIO_ELABORATO_CORRETTAMENTE");

		if (dipendenti.isEmpty()) {
			response.setResponse(null);
			return response;
		}

		LOGGER.info("Numero dei record: " + dipendenti.size());

		// DipendentiDto dto = new DipendentiDto();

		response.setResponse(dipendenti);
		return response;

	}

	@GetMapping(value = "/idList/{id}", produces = "application/json")
	public BaseResponseDto<?> listDipById(@PathVariable("id") Long id)

	{
		BaseResponseDto<?> response = new BaseResponseDto<>();
		LOGGER.info("****** Otteniamo il dip con Id: " + id + "*******");

		List<Optional<DipendentiDao>> lista = dipendentiService.parseOptional(id);
		if (lista == null) {
			response.setResponse(null);
			response.setMessagge("NON_TROVO_IL_DIPENDENTE");
			return response;
		}
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessagge("SERVIZIO_ELABORATO_CORRETTAMENTE");
		response.setResponse(lista);
		return response;

	}

	@GetMapping(value = "/id/{id}", produces = "application/json")
	public BaseResponseDto<?> DipById(@PathVariable("id") Long id)

	{
		BaseResponseDto<?> response = new BaseResponseDto<>();
		LOGGER.info("****** Otteniamo il dip con Id: " + id + "*******");

		Optional<DipendentiDao> dip = dipendentiService.selById(id);

		if (dip == null) {
			response.setResponse(null);
			response.setMessagge("NON_TROVO_IL_DIPENDENTE");
			return response;
		}

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessagge("SERVIZIO_ELABORATO_CORRETTAMENTE");
		response.setResponse(dip);
		return response;


	}

	@DeleteMapping(value = "/elimina/{id}")
	public BaseResponseDto<?> deleteDip(@PathVariable("id") Long id) {
		BaseResponseDto<?> response = new BaseResponseDto<>();
		LOGGER.info("Eliminiamo il dipendente con id " + id);

		Optional<DipendentiDao> dipendenti = dipendentiService.selById(id);

		if (dipendenti == null) {
			response.setResponse(null);
			response.setMessagge("NON_TROVO_IL_DIPENDENTE");
			return response;
		}

		dipendentiService.delDip(id);

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessagge("SERVIZIO_ELABORATO_CORRETTAMENTE");
		return response;
	}

	@PutMapping(value = "/modifica")
	public BaseResponseDto<?> updateDip(@RequestBody DipendentiDao dip) {
		BaseResponseDto<?> response = new BaseResponseDto<>();
		LOGGER.info("***** Modifichiamo il dip con id " + dip.getIdDip() + " *****");

		if (dip.getIdDip() > 0) {
			dipendentiService.insDip(dip);

			response.setTimestamp(new Date());
			response.setStatus(HttpStatus.OK.value());
			response.setMessagge("SERVIZIO_ELABORATO_CORRETTAMENTE");
			return response;
		} else {
			response.setTimestamp(new Date());
			response.setMessagge("SERVIZIO_NON_ELABORATO_CORRETTAMENTE");
			return response;
		}
	}

	@PostMapping(value = "/inserisci")
	public BaseResponseDto<?> createDip(@RequestBody DipendentiDao dip) {

		BaseResponseDto<?> response = new BaseResponseDto<>();
		dipendentiService.insDip(dip);

		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessagge("SERVIZIO_ELABORATO_CORRETTAMENTE");
		return response;
	}

}
