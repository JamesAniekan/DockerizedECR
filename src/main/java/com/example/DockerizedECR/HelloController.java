package com.example.DockerizedECR;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloEcr(){
        return "Hello docker ECR";
    }
}
