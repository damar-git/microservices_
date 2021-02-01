package com.damar.microservices.customer.controller;

import com.damar.microservices.customer.api.CustomerApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CustomerController implements CustomerApi {

    @Value("${server.port}")
    private String serverPortNumber;

    @Override
    public ResponseEntity<String> getCustomerById(Long customerId) {
        log.info("getCustomerById, customerId {}, server port: {}", customerId,
                serverPortNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(String.format("GET Customer, server port: %s", serverPortNumber));
    }

}
