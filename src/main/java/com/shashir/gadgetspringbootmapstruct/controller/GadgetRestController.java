package com.shashir.gadgetspringbootmapstruct.controller;

import com.shashir.gadgetspringbootmapstruct.map.GadgetMapper;
import com.shashir.gadgetspringbootmapstruct.model.GadgetDTO;
import com.shashir.gadgetspringbootmapstruct.service.GadgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GadgetRestController {

    private final GadgetService gadgetService;
    private final GadgetMapper gadgetMapper;

    @GetMapping(value = "/maps")
    public String display() {
        return "Hello Mapstruct...!";
    }

    @GetMapping(value = "/gadget/{gadgetId}")
    public ResponseEntity<GadgetDTO> fetchGadgetById(@PathVariable Long gadgetId) {
        return new ResponseEntity<>(gadgetMapper.toGadgetDTO(gadgetService.fetchByGadgetId(gadgetId)), HttpStatus.OK);
    }

    @PostMapping(value = "/gadget")
    public ResponseEntity<GadgetDTO> persistGadget(@RequestBody GadgetDTO gadgetDto) {

        return new ResponseEntity<>(gadgetMapper.toGadgetDTO(gadgetService.persistGadget(gadgetMapper.toGadget(gadgetDto))), HttpStatus.OK);
    }
}
