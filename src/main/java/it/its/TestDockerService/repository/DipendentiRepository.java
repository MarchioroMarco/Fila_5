package it.its.TestDockerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.TestDockerService.dao.DipendentiDao;

public interface DipendentiRepository extends JpaRepository<DipendentiDao, Long>{ //DipendentiDao (entità) e identificativo(Long)

//	Promo findByIdPromo(String IdPromo);
	//sull'esempio degli articoli nella sezione promo c'era questo su Repository per quanto riguarda il select
	//per quanto riguarda il delete non c'era niente
}
