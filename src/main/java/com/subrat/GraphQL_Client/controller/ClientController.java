package com.subrat.GraphQL_Client.controller;

import com.subrat.GraphQL_Client.request.CreateStudentRequest;
import com.subrat.GraphQL_Client.response.StudentResponse;
import com.subrat.GraphQL_Client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/get/{id}")
    public StudentResponse getStudent(@PathVariable Integer id) {
        return clientService.getStudent(id);
    }

    @PostMapping
    public StudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
        return clientService.createStudent(createStudentRequest);
    }
}
