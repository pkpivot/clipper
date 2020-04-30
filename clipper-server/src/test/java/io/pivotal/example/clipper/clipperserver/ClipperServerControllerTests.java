package io.pivotal.example.clipper.clipperserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.util.AssertionErrors.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClipperServerControllerTests {

   // @Autowired
   // TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;


     @Test
    void putDataEndpointShouldReturn200OK(){
        String someDate = "Hello World";
        HttpEntity<String> request = new HttpEntity<>(someDate);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(String.format("http://localhost:%d/api/clip", port),request, String.class);

        assertEquals("Did not get 200", HttpStatus.OK,  response.getStatusCode());
    }

    @Test
    void gettDataEndpointShouldReturnData(){
        RestTemplate restTemplate = new RestTemplate();
        String someDate = "Hello World";

        {
            HttpEntity<String> request = new HttpEntity<>(someDate);

            ResponseEntity<String> response = restTemplate.postForEntity(String.format("http://localhost:%d/api/clip", port), request, String.class);
            assertEquals("Did not get 200", HttpStatus.OK, response.getStatusCode());
        }
        {
            ResponseEntity<String> response = restTemplate.getForEntity(String.format("http://localhost:%d/api/clip", port),  String.class);
            assertEquals("Did not retrieve data", someDate, response.getBody());
        }



    }
}
