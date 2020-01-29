package it.its.TestDockerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.TestDockerService.dao.NazioniDao;

public interface NazioniRepository extends JpaRepository<NazioniDao, String>{

}
