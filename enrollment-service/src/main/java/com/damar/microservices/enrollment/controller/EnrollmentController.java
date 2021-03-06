package com.damar.microservices.enrollment.controller;

import com.damar.microservices.enrollment.api.EnrollmentApi;
import com.damar.microservices.enrollment.model.EnrollmentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EnrollmentController implements EnrollmentApi {

    @Value("${server.port}")
    private Integer serverPortNumber;


    @Override
    public ResponseEntity<EnrollmentResponse> getHttpPort() {
        log.info("HTTP Server Port: {}", serverPortNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(EnrollmentResponse
                        .builder()
                        .service("Enrollment Service")
                        .httpPort(serverPortNumber)
                        .build());
    }
}
