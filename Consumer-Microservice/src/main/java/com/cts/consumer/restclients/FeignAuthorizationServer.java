package com.cts.consumer.restclients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.consumer.payload.request.UsernamePasswordRequest;

@FeignClient(name = "AuthorizationServer", url = "${AUTHORIZATION_SERVICE:http://localhost:8080}")
public interface FeignAuthorizationServer {

    @PostMapping(value = "/account/login")
    public ResponseEntity<Object> authenticateUser(@RequestBody UsernamePasswordRequest usernamePasswordRequest);
}
