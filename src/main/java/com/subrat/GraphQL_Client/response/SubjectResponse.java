package com.subrat.GraphQL_Client.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectResponse {
    private Long id;
    private String subjectName;
    private Double marksObtained;
}
