package com.demo.nbp.nbp.client;

import com.demo.nbp.domain.GoldRates;
import com.demo.nbp.domain.GoldRatesDto;
import com.demo.nbp.scheduler.DBScheduler;
import com.demo.nbp.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class DbClient {

    @Autowired
    DBScheduler scheduler;

    @Autowired
    DbService service;


    public BigDecimal average() {
        List<GoldRates> averageList = service.allRates();
        double ratesSum = 0;
        for (GoldRates rates : averageList) {
            ratesSum += rates.getRate();
        }

        BigDecimal countAverage = BigDecimal.valueOf(ratesSum).divide(BigDecimal.valueOf(scheduler.countDays()));
        System.out.println("Srednia kursu złota z " + scheduler.countDays() + " dni wynosi " + countAverage +"pln");
        return countAverage;
    }

    public GoldRates minValue() {
        List<GoldRates> averageList = service.allRates();
        averageList.sort(Comparator.comparing(GoldRates::getRate));
        GoldRates min =  new GoldRates(averageList.get(0).getDate(), averageList.get(0).getRate());
        return min;
    }

    public GoldRates maxValue() {
        List<GoldRates> averageList = service.allRates();
        averageList.sort(Comparator.comparing(GoldRates::getRate).reversed());
        GoldRates min = new GoldRates(averageList.get(0).getDate(), averageList.get(0).getRate());
        return min;
    }

}
