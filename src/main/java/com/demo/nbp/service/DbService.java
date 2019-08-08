package com.demo.nbp.service;

import com.demo.nbp.domain.GoldRates;
import com.demo.nbp.repository.GoldRatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    @Autowired
    GoldRatesRepository goldRatesRepository;

    public GoldRates saveRate(final GoldRates goldRates) {
        return goldRatesRepository.save(goldRates);

    }
}
