package com.shashir.gadgetspringbootmapstruct.controller;

import com.shashir.gadgetspringbootmapstruct.model.GadgetDTO;
import com.shashir.gadgetspringbootmapstruct.service.GadgetService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/")
public class GadgetRestController {

    @Autowired
    private GadgetService gadgetService;

    /* http://localhost:9997/gadget/1 */
    @GetMapping(value = "/gadget/{gadgetId}")
    public ResponseEntity<GadgetDTO> fetchGadgetById(@PathVariable Long gadgetId) {

        GadgetDTO gadgetDto = gadgetService.fetchByGadgetId(gadgetId);

        if (ObjectUtils.isEmpty(gadgetDto)) {
            return new ResponseEntity<>(gadgetDto, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(gadgetDto, HttpStatus.OK);
    }

    /* http://localhost:9997/gadgetQuery?gid=1
     * http://localhost:9997/gadgetQuery?gid=1&gid2=1 */
    @GetMapping(value = "/gadgetQuery")
    public ResponseEntity<GadgetDTO> fetchGadgetByIdQueryParam(
            @RequestParam(required = true, value = "gid") Long gadgetId) {

        GadgetDTO gadgetDto = gadgetService.fetchByGadgetId(gadgetId);
        if (ObjectUtils.isEmpty(gadgetDto)) {
            return new ResponseEntity<>(gadgetDto, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(gadgetDto, HttpStatus.OK);
    }

    @GetMapping(value = "/gadget")
    public ResponseEntity<List<GadgetDTO>> fetchGadgets() {

        List<GadgetDTO> gadgetDtoList = gadgetService.fetchGadgets();
        if (gadgetDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(gadgetDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "/gadget")
    public ResponseEntity<GadgetDTO> persistGadget(@RequestBody @Valid GadgetDTO gadgetDto) {

        return new ResponseEntity<>(gadgetService.persistGadget(gadgetDto), HttpStatus.OK);
    }
}
