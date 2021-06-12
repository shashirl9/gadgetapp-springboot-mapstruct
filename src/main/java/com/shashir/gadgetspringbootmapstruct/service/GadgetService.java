package com.shashir.gadgetspringbootmapstruct.service;

import com.shashir.gadgetspringbootmapstruct.map.GadgetMapper;
import com.shashir.gadgetspringbootmapstruct.model.Gadget;
import com.shashir.gadgetspringbootmapstruct.model.GadgetDTO;
import com.shashir.gadgetspringbootmapstruct.repository.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GadgetService {

    @Autowired
    private GadgetRepository gadgetRepository;

    @Autowired
    private GadgetMapper gadgetMapper;

    public GadgetDTO fetchByGadgetId(Long gadgetId) {
        return gadgetMapper.toGadgetDTO(gadgetRepository.findById(gadgetId).get());
    }

    public GadgetDTO persistGadget(GadgetDTO gadgetDto) {
        Gadget gadget = gadgetMapper.toGadget(gadgetDto);
        return gadgetMapper.toGadgetDTO(gadgetRepository.save(gadget));
    }

    public List<GadgetDTO> fetchGadgets(){
        return gadgetMapper.toGadgetDTOList(gadgetRepository.findAll());
    }
}
