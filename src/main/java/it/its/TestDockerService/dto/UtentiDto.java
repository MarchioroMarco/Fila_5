package it.its.TestDockerService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtentiDto {

	private int id;
	private String username;
	private String password;
	private String ruolo;
	
}
