package com.trinity.dashboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetidorRepository extends JpaRepository<Competidor, Integer> {
}