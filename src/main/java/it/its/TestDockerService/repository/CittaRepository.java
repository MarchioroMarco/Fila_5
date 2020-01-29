package it.its.TestDockerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.TestDockerService.dao.CittaDao;

public interface CittaRepository extends JpaRepository<CittaDao, Long>{

}
