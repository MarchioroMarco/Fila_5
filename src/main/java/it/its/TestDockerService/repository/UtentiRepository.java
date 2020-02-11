package it.its.TestDockerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.TestDockerService.dao.UtentiDao;

public interface UtentiRepository extends JpaRepository<UtentiDao, Long>{

}
