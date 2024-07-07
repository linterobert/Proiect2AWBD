package com.example.feignProject;

import com.example.feignProject.Config.SampleClientConfiguration;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@FeignClient(value = "sampleclient",
        url = "${sample.client.url}",
        configuration = SampleClientConfiguration.class
)
public interface SampleClient {
    @RequestMapping(method = RequestMethod.GET,
            value = "/sample",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Object> getSampleDataByIds(@RequestParam("ids") List<Long> ids);
}
