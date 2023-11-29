package com.matheus.projetointegradoriii.domain.repository;

import com.matheus.projetointegradoriii.domain.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> getCarByIsAvailable(boolean isAvailable);
}
