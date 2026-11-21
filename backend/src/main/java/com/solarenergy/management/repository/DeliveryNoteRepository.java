package com.solarenergy.management.repository;

import com.solarenergy.management.entity.DeliveryNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryNoteRepository extends JpaRepository<DeliveryNote, String> {
}
