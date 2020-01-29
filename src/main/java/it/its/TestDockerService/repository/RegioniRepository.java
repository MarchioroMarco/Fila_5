package it.its.TestDockerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.TestDockerService.dao.RegioniDao;

public interface RegioniRepository extends JpaRepository<RegioniDao, Long>{

}
