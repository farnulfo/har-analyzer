package org.arnulfo.har.analyzer;

import com.example.types.Entry;
import com.example.types.HarSchema;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws JsonProcessingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        HarSchema har = new HarSchema();
        String s = objectMapper.writeValueAsString(har);
        System.out.println("s:" + s);

        har = objectMapper.readValue(new File("test.har"), HarSchema.class);
        //System.out.println("har = " + har);
        har.getLog().getEntries().forEach(e -> System.out.println(e.getRequest().getHeaders()));
        har.getLog().getEntries().forEach(e -> analyze(e));
    }

    private static void analyze(Entry e) {
        if (e.getRequest().getMethod().equals("GET")) {
            System.out.println("GET");
        }
    }
}
