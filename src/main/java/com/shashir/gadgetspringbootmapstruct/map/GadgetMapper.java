package com.shashir.gadgetspringbootmapstruct.map;

import com.shashir.gadgetspringbootmapstruct.model.Gadget;
import com.shashir.gadgetspringbootmapstruct.model.GadgetDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GadgetMapper {

    public GadgetDTO toGadgetDTO(Gadget gadget);

    public Gadget toGadget(GadgetDTO gadgetDTO);

    public List<GadgetDTO> toGadgetDTOList(List<Gadget> gadget);
}
