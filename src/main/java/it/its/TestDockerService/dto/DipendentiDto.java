package it.its.TestDockerService.dto;

import java.util.List;

import it.its.TestDockerService.dao.DipendentiDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DipendentiDto {

	private List<DipendentiDao> dipendentiData;
}
