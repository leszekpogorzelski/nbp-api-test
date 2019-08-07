package com.demo.nbp.nbp;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
@Getter
public class NbpConfig {

    @Value("http://api.nbp.pl/api/cenyzlota")
    private String nbpApiEndPoint;

}
