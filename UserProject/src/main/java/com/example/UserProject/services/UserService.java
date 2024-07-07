package com.example.UserProject.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "report-header", fallbackMethod = "fallbackGetReportHeaders")
    @Retry(name = "report-header")
    public String getReportHeaders(String type) {
        String url = "http://report-header-service/report_header";
        if (type != null && !type.isEmpty()) {
            url += "?type=" + type;
        }
        return restTemplate.getForObject(url, String.class);
    }

    @CircuitBreaker(name = "report-header", fallbackMethod = "fallbackGetReportHeaders")
    @Retry(name = "report-header")
    public String getPetImageById(int id) {
        String url = "http://report-header-service/petImage/" + id;
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackGetReportHeaders(String type, Throwable throwable) {
        // Returnează un mesaj de fallback sau altă logică
        return "Fallback response: Unable to get report headers";
    }
}
