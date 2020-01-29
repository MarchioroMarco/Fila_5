package it.its.TestDockerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.TestDockerService.dao.ProvinceDao;

public interface ProvinceRepository extends JpaRepository<ProvinceDao, Long>{

}
