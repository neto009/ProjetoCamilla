package com.camilla.service;

import com.camilla.domain.Form;
import com.camilla.domain.User;
import com.camilla.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {

    @Autowired
    private FormRepository repository;

    public List<Form> listAll() {
        return repository.findAll(Sort.by("email").ascending());
    }

    public Form save(Form form) {
        return repository.save(form);
    }
}
