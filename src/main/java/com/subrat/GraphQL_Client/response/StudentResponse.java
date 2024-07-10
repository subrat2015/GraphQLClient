package com.subrat.GraphQL_Client.response;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;
    private List<SubjectResponse> learningSubjects;
    private String fullName;

}
