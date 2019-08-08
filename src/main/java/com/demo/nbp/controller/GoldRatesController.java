package com.demo.nbp.controller;

import com.demo.nbp.domain.GoldRatesDto;
import com.demo.nbp.nbp.client.NbpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class GoldRatesController {

    @Autowired
    NbpClient nbpClient;

    @RequestMapping(method = RequestMethod.GET, value = "/value")
    public List<GoldRatesDto> getRates() {
        return nbpClient.getTodayRate();
    }
}

