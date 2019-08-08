package com.demo.nbp.scheduler;

import com.demo.nbp.controller.GoldRatesController;
import com.demo.nbp.domain.GoldRatesDto;
import com.demo.nbp.mapper.GoldRatesMapper;
import com.demo.nbp.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBScheduler {

    @Autowired
    GoldRatesController goldRatesController;

    @Autowired
    GoldRatesMapper goldRatesMapper;

    @Autowired
    DbService service;


    @Scheduled(fixedDelay = 20000)
    public void saveRates() {
        List<GoldRatesDto> list = goldRatesController.getRates();
        service.saveRate(goldRatesMapper.mapToGoldRates(list.get(0)));


    }


}
