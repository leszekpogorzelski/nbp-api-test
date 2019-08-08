package com.demo.nbp.repository;

import com.demo.nbp.domain.GoldRates;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface GoldRatesRepository extends CrudRepository<GoldRates, LocalDate> {

    @Override
    GoldRates save (GoldRates goldRates);
}
