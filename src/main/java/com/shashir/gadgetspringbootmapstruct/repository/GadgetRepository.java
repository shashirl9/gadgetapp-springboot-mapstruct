package com.shashir.gadgetspringbootmapstruct.repository;

import com.shashir.gadgetspringbootmapstruct.model.Gadget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GadgetRepository extends JpaRepository<Gadget, Long> {

}
