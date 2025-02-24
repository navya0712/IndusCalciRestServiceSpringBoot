package com.indus.training.IndusCalciRestServiceSpringBoot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.indus.training.core.domain.CalciInput;
import com.indus.training.core.domain.CalciOutput;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestCalciController {

    private final String BASE_URL = "http://localhost:9090";
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        restTemplate = new RestTemplate();
    }

    @AfterEach
    public void tearDown() {
        restTemplate = null;
    }

    @Test
    public void testAdd() {
        CalciInput input = new CalciInput();
        input.setParam1(5.0);
        input.setParam2(3.0);
        ResponseEntity<CalciOutput> response = restTemplate.postForEntity(BASE_URL + "/add", input, CalciOutput.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(8.0, response.getBody().getResult()); // Expected result
    }

    @Test
    public void testSubtract() {
        CalciInput input = new CalciInput();
        input.setParam1(4.0);
        input.setParam2(6.0);
        ResponseEntity<CalciOutput> response = restTemplate.postForEntity(BASE_URL + "/subtract", input, CalciOutput.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(-2.0, response.getBody().getResult()); // Expected result
    }

    @Test
    public void testMultiply() {
        CalciInput input = new CalciInput();
        input.setParam1(3.0);
        input.setParam2(4.0);
        ResponseEntity<CalciOutput> response = restTemplate.postForEntity(BASE_URL + "/multiply", input, CalciOutput.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(12.0, response.getBody().getResult()); // Expected result
    }

    @Test
    public void testDivide() {
        CalciInput input = new CalciInput();
        input.setParam1(20.0);
        input.setParam2(4.0);
        ResponseEntity<CalciOutput> response = restTemplate.postForEntity(BASE_URL + "/divide", input, CalciOutput.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(5.0, response.getBody().getResult()); // Expected result
    }
}
