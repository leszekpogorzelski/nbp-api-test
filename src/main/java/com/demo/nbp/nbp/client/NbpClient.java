package com.demo.nbp.nbp.client;

import com.demo.nbp.domain.GoldRatesDto;
import com.demo.nbp.nbp.config.NbpConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

@Component
public class NbpClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(NbpClient.class);

    @Autowired
    NbpConfig nbpConfig;

    @Autowired
    RestTemplate restTemplate;

    public List<GoldRatesDto> getTodayRate() throws RestClientException {
            URI uri = UriComponentsBuilder.fromHttpUrl(nbpConfig.getNbpApiEndPoint())
                    .build().encode().toUri();

            try {GoldRatesDto[] apiResponse = restTemplate.getForObject(uri, GoldRatesDto[].class);
                LOGGER.info("Succeeded collecting data from NBP!");
                return Arrays.asList(ofNullable(apiResponse).orElse(new GoldRatesDto[0]));

            } catch (RestClientException e) {

                LOGGER.error(e.getMessage());

              return new ArrayList<>();
            }
        }
}

