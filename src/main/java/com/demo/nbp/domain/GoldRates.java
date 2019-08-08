package com.demo.nbp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "RATES")
public class GoldRates {

    @Id
    @NotNull
    @Column(name = "DATE", unique = true)
    private LocalDate date;

    @Column(name = "RATE")
    private double rate;
}
