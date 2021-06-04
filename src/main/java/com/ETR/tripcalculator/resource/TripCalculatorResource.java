package com.ETR.tripcalculator.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface TripCalculatorResource
{
    @GetMapping(value = "/etr/toll",produces = "application/json")
    ResponseEntity getTollDetails(@RequestParam String source, @RequestParam String destination);
}
