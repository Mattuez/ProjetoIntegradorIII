package com.matheus.projetointegradoriii.domain.repository;

import com.matheus.projetointegradoriii.domain.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
