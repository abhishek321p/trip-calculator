package com.ETR.tripcalculator.service;

import com.ETR.tripcalculator.models.Locations;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

@Service
public class InterchangesService {
    @Value("${interchanges.file.path}")
    private String path;

    /***
     * Reads the Json file
     * @return Locations
     * @throws IOException
     */
    public Locations fetchJson() throws IOException {
        File file = ResourceUtils.getFile(path);
        //File is found
        System.out.println("File Found : " + file.exists());

        ObjectMapper jsonMapper = new ObjectMapper();
        return jsonMapper.readValue(file, new TypeReference<Locations>() {
        });
    }
}
