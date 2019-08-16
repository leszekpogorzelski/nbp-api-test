package com.demo.nbp.controller;

import com.demo.nbp.domain.GoldRates;
import com.demo.nbp.domain.GoldRatesDto;
import com.demo.nbp.mapper.GoldRatesMapper;
import com.demo.nbp.nbp.client.DbClient;
import com.demo.nbp.nbp.client.NbpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class GoldRatesController {

    @Autowired
    NbpClient nbpClient;

    @Autowired
    DbClient dbClient;

    @Autowired
    GoldRatesMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "/value")
    public List<GoldRatesDto> getRates() {
        return nbpClient.getTodayRate();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/value/average")
    public BigDecimal getAverage() {
        return dbClient.average();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/value/min")
    public GoldRatesDto getMinValue() {
        return mapper.mapToGoldRatesDto(dbClient.minValue());
    }
    @RequestMapping(method = RequestMethod.GET, value = "/value/max")
    public GoldRates getMaxValue() {
        return dbClient.maxValue();
    }
}

