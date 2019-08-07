package com.demo.nbp.controller;

import com.demo.nbp.domain.GoldRatesDto;
import com.demo.nbp.nbp.NbpConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class GoldRatesController {

    @Autowired
    NbpConfig nbpConfig;

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(method = RequestMethod.GET, value = "/value")
    public List<GoldRatesDto> getTodayRate() throws RestClientException {
        URI uri = UriComponentsBuilder.fromHttpUrl(nbpConfig.getNbpApiEndPoint())
                .build().encode().toUri();

        try {GoldRatesDto[] apiResponse = restTemplate.getForObject(uri, GoldRatesDto[].class);
            return Arrays.asList(ofNullable(apiResponse).orElse(new GoldRatesDto[0]));

        } catch (RestClientException e) {

            return new ArrayList<>();
        }
    }
}
