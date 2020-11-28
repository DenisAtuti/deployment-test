package com.atutidennis.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atutidennis.model.Booking;

@Repository
public interface BookingRepository  extends JpaRepository<Booking, Integer>{
	
	Page<Booking> findByUsernameLikeOrderByIdDesc(Pageable pageable, String name);
}
