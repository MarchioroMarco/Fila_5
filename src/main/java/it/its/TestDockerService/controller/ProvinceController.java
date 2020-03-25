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
import it.its.TestDockerService.dto.ProvinceDto;
import it.its.TestDockerService.service.ProvinceService;

@RestController
@RequestMapping(value = "api/province")
public class ProvinceController {

	@Autowired
	private ProvinceService provinceService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DipendentiController.class);
	
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<ProvinceDto>> fetchAll(){
		
		BaseResponseDto<List<ProvinceDto>> response = new BaseResponseDto<>();
		LOGGER.info("******Otteniamo tutto******");
		
		List<ProvinceDto> province = provinceService.parseDto();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessagge("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		if(province.isEmpty()) {
			response.setResponse(null);
			return response;
		}
		
		LOGGER.info("Numero dei record: " + province.size());
		
		response.setResponse(province);
		return response;
		
	}
}
