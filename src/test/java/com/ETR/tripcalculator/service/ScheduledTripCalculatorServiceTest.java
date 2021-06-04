package com.ETR.tripcalculator.service;

import com.ETR.tripcalculator.models.TollDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class ScheduledTripCalculatorServiceTest {
    @Autowired
    ScheduledTripCalculatorService scheduledTripCalculatorService;

    @BeforeEach
    public void setup() throws IOException {
        scheduledTripCalculatorService.loadTollLineMap();
    }

    @Test
    public void testDistanceAndTollBetweenQEWandApplebyLine() {
        TollDetails tollDetails = scheduledTripCalculatorService.getTollDetails("QEW", "Appleby Line");
        assertEquals(9.909, tollDetails.getDistance(), 0.001);
        assertEquals(2.47725, tollDetails.getPrice(), 0.001);
    }

    @Test
    public void testNullIsReturnedWhenDestinationIsEmpty() {
        TollDetails tollDetails = scheduledTripCalculatorService.getTollDetails("QEW", "");
        assertNull(tollDetails);
    }

    @Test
    public void testNullIsReturnedWhenSourceIsEmpty() {
        TollDetails tollDetails = scheduledTripCalculatorService.getTollDetails("", "Appleby Line");
        assertNull(tollDetails);
    }

    @Test
    public void testNullIsReturnedWhenDestinationIsNotOpenYet() {
        TollDetails tollDetails = scheduledTripCalculatorService.getTollDetails("QEW", "Sideline 26");
        assertNull(tollDetails);
    }

    @Test
    public void testTollIsCalculatedWhenNotOpenInterchangeISInRoute() {
        TollDetails tollDetails = scheduledTripCalculatorService.getTollDetails("York Durham Line", "Brock Road");
        assertEquals(7.854, tollDetails.getDistance(), 0.001);
        assertEquals(1.963, tollDetails.getPrice(), 0.001);
    }


    @Test
    public void testNullIsReturnedWhenSourceIsNotOpenYet() {
        TollDetails tollDetails = scheduledTripCalculatorService.getTollDetails("Sideline 26", "QEW");
        assertNull(tollDetails);
    }
}
