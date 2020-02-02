package it.its.TestDockerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.TestDockerService.dao.DipendentiDao;

public interface DipendentiRepository extends JpaRepository<DipendentiDao, Long>{ //DipendentiDao (entità) e identificativo(Long)

}
