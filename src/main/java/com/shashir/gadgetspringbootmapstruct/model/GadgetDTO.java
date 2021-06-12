package com.shashir.gadgetspringbootmapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class GadgetDTO {

    public String gadgetName;
    public String gadgetCategory;
    public Boolean gadgetAvailability;
    public Double gadgetPrice;
}