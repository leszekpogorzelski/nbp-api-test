package com.demo.nbp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GoldRates {
    //private Long id;
    private String date;
    private double rate;
}
