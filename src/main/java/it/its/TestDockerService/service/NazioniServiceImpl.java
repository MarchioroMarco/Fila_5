package it.its.TestDockerService.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.its.TestDockerService.dao.NazioniDao;
import it.its.TestDockerService.dto.NazioniDto;
import it.its.TestDockerService.repository.NazioniRepository;

@Service
@Transactional
public class NazioniServiceImpl implements NazioniService{

	@Autowired
	NazioniRepository nazioniRepository;

	@Override
	public List<NazioniDao> selTutti() {
		return nazioniRepository.findAll();
	}

	@Override
	public List<NazioniDto> parseDto() {
		List<NazioniDto> dto = new ArrayList<NazioniDto>();
		List<NazioniDao> dao = this.selTutti();
		for (NazioniDao d : dao) {
			dto.add(new NazioniDto(d.getIso(),d.getDescrizione()));
		}
		return dto;
	}

	@Override
	public HttpStatus all() {

		HttpEntity<String> request = new HttpEntity<String>("https://restcountries.eu/rest/v2/all");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8090/api/nazioni", HttpMethod.GET, request, String.class);
		responseEntity.getStatusCode();
		
		if(responseEntity.getStatusCode().equals(HttpStatus.OK)) {
		 responseEntity.getBody();
		}else {
			return HttpStatus.BAD_REQUEST;
		}
		return responseEntity.getStatusCode();
	}

	

}
