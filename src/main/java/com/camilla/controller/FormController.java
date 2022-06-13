package com.camilla.controller;

import com.camilla.domain.Form;
import com.camilla.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/form")
public class FormController {

    @Autowired
    private FormService service;

    @PostMapping
    public ResponseEntity<Form> createForm(@RequestBody @Valid Form form) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(form));
    }
}
