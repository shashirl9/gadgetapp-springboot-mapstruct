package com.shashir.gadgetspringbootmapstruct.service;

import com.shashir.gadgetspringbootmapstruct.map.GadgetMapper;
import com.shashir.gadgetspringbootmapstruct.model.Gadget;
import com.shashir.gadgetspringbootmapstruct.repository.GadgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GadgetService {

    @Autowired
    private GadgetRepository gadgetRepository;

    public Gadget fetchByGadgetId(Long gadgetId) {
        return gadgetRepository.findById(gadgetId).get();
    }

    public Gadget persistGadget(Gadget gadget) {
        return gadgetRepository.save(gadget);
    }
}
