package io.twotle.ssn.controller;

import io.swagger.annotations.Api;
import io.twotle.ssn.component.CustomException;
import io.twotle.ssn.dto.RegisterDTO;
import io.twotle.ssn.dto.ResultResponseDTO;
import io.twotle.ssn.entity.User;
import io.twotle.ssn.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
@Api(tags = {"1. User"})
public class AuthController {
    private final AuthService authService;

    @PostMapping("/new")
    public ResponseEntity<ResultResponseDTO> signUp(@RequestBody @Validated RegisterDTO registerDTO) throws CustomException {
        User newUser = authService.signUp(registerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResultResponseDTO(true));
    }



}
