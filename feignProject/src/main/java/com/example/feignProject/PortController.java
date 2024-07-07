package com.example.feignProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortController {

    //@Value("${port.no}")
    private String portNo;

    @GetMapping("/port")
    public String getPortNo() {
        return "salut";
    }
}
