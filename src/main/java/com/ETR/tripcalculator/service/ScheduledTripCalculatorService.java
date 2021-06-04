package com.ETR.tripcalculator.service;

import com.ETR.tripcalculator.models.Location;
import com.ETR.tripcalculator.models.TollDetails;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ScheduledTripCalculatorService {

    private final Map<String, Double> tollLineMap = new HashMap<>();
    private static final long INTERVAL = 1000 * 60 * 60 * 24;

    @Value("${toll.rate}")
    private String rate;

    @Autowired
    InterchangesService interchangesService;

    /***
     * Reloads the number line every 24 hours reading it from json
     * @throws IOException
     */
    @Scheduled(fixedRate = INTERVAL)
    public void loadTollLineMap() throws IOException {
        double distanceFromFirstToll = 0;
        for (Map.Entry<Integer, Location> entry : interchangesService.fetchJson().getLocations().entrySet()) {
            if (entry.getKey() == 1) {
                // for building the number line we consider first interchange to be at 0.
                tollLineMap.put(entry.getValue().getName(), (double) 0);
            } else {
                // we dont want to consider interchanges that are not built yet, so we skip those with 0 distance.
                if (entry.getValue().getRoutes().get(1).getDistance() > 0) {
                    // interchange distance from 0 = distance from previous interchange + distance from 0 to previous interchange.
                    distanceFromFirstToll += entry.getValue().getRoutes().get(1).getDistance();
                    tollLineMap.put(entry.getValue().getName(), distanceFromFirstToll);
                }
            }
        }
    }

    /***
     * gets the toll details
     * @param source source point
     * @param destination destination point
     * @return tool details
     */
    public TollDetails getTollDetails(String source, String destination) {
        if (!tollLineMap.containsKey(source) || !tollLineMap.containsKey(destination) || StringUtils.isBlank(source) || StringUtils.isBlank(destination)) {
            return null;
        }
        double distance = Math.abs(tollLineMap.get(source) - tollLineMap.get(destination));
        return TollDetails.create(distance, distance * Float.parseFloat(rate));
    }
}
