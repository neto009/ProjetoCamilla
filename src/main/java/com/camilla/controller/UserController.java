package com.camilla.controller;

import com.camilla.domain.Form;
import com.camilla.domain.User;
import com.camilla.excel.FormExcelExporter;
import com.camilla.service.FormService;
import com.camilla.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private FormService service;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> participante(@PathVariable Long id) {
        User existingItemOptional = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(existingItemOptional);
    }

    @GetMapping
    public ResponseEntity<List<User>> users() {
        try {
            List<User> items = userService.todos();
            if (items.isEmpty())
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            return ResponseEntity.status(HttpStatus.OK).body(items);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<User> novo(@RequestBody @Valid User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualiza(@PathVariable Long id, @RequestBody User user) {
        User user1 = userService.update(id, user);

        if (user1 != null) {
            return ResponseEntity.status(HttpStatus.OK).body(userService.update(id, user));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/users/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Form> listForm = service.listAll();

        FormExcelExporter excelExporter = new FormExcelExporter(listForm);

        excelExporter.export(response);
    }
}
