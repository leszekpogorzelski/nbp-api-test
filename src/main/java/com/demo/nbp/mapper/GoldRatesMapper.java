package com.demo.nbp.mapper;

import com.demo.nbp.controller.GoldRatesController;
import com.demo.nbp.domain.GoldRates;
import com.demo.nbp.domain.GoldRatesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoldRatesMapper {


    public GoldRates mapToGoldRates(final GoldRatesDto goldRatesDto) {
        return new GoldRates(goldRatesDto.getDate(), goldRatesDto.getRate());
    }

    public GoldRatesDto mapToGoldRatesDto(final GoldRates goldRates) {
        return new GoldRatesDto(goldRates.getDate(), goldRates.getRate());
    }
}
