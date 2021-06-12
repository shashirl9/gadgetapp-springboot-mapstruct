package com.shashir.gadgetspringbootmapstruct.model;

import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class GadgetDTO {

    @NotNull
    public String gadgetName;

    @NotNull
    public String gadgetCategory;

    @NotNull
    public Boolean gadgetAvailability;

    @NotNull
    public Double gadgetPrice;
}