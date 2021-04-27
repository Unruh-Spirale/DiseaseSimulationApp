package com.simulation.simulationapp.repository;

import com.simulation.simulationapp.model.Calc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalcRepository extends JpaRepository<Calc,Long> {
}
