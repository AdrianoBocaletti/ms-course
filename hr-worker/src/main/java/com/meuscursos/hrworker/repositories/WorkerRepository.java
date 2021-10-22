package com.meuscursos.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meuscursos.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
