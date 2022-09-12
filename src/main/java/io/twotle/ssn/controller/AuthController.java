package io.twotle.ssn.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
@Api(tags = {"1. User"})
public class AuthController {

    @GetMapping("/new")
    public String test() {
        throw new IllegalArgumentException();
    }




}
