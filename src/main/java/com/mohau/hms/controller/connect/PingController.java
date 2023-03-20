package com.mohau.hms.controller.connect;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/connect")
public class PingController {
    @PostMapping("/Ping")
    public ResponseEntity<String> connectionEstablished(){
        return ResponseEntity.ok("You have successfully connected to devmo's API");
    }
}
