package com.hollies.patientapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphQLController {
    
    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }
}
