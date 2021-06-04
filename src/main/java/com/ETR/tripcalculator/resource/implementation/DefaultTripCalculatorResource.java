package com.ETR.tripcalculator.resource.implementation;

import com.ETR.tripcalculator.models.TollDetails;
import com.ETR.tripcalculator.resource.TripCalculatorResource;
import com.ETR.tripcalculator.service.ScheduledTripCalculatorService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultTripCalculatorResource implements TripCalculatorResource {
    @Autowired
    ScheduledTripCalculatorService scheduledTripCalculatorService;

    @Override
    public ResponseEntity getTollDetails(String source, String destination) {
        try{
            if (StringUtils.isBlank(source) || StringUtils.isBlank(destination)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid parameters");
            }
            TollDetails tollDetails = scheduledTripCalculatorService.getTollDetails(source, destination);
            if(tollDetails == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid parameters");
            }
            return ResponseEntity.ok().body(tollDetails);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("service down, check back later");
        }
    }
}
