package com.example.feignProject;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {

    private final SampleClient sampleClient;

    @GetMapping
    public ResponseEntity getSampleDataByIds(@RequestParam("ids") List<Long> ids) {
        try {
            ResponseEntity responseEntity = sampleClient.getSampleDataByIds(ids);

            return new ResponseEntity(responseEntity.getBody(), responseEntity.getStatusCode());
        } catch (FeignException feignException) {
            return new ResponseEntity(feignException.responseBody(), HttpStatus.valueOf(feignException.status()));
        }
    }
}
