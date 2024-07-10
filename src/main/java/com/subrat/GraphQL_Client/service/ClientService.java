package com.subrat.GraphQL_Client.service;

import com.subrat.GraphQL_Client.request.CreateStudentRequest;
import com.subrat.GraphQL_Client.response.StudentResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class ClientService {

    @Autowired
    GraphQLWebClient graphQLWebClient;

    public StudentResponse getStudent (Integer id) {
        /*String queryStr = "query {\r\n"
                +"  student(id : "+ id +") {\r\n"
                +"  id \r\n"
                +"  firstName\r\n"
                +"  lastName\r\n"
                +"  email\r\n"
                +"  street\r\n"
                +"  city\r\n"
                +"learningSubjects(subjectNameFilter : All) {\r\n"
                +"  id \r\n"
                +"  subjectName \r\n"
                +"  marksObtained \r\n"
                +"  } \r\n"
                +"  fullName \r\n"
                +"  } \r\n"
                +"}";*/
        Map<String, Integer> variables = new HashMap<>();
        variables.put("id", id);

        String queryStr = "query student($id : int) {\r\n"
                +"  student(id : $id) {\r\n"
                +"  id \r\n"
                +"  firstName\r\n"
                +"  lastName\r\n"
                +"  email\r\n"
                +"  street\r\n"
                +"  city\r\n"
                +"learningSubjects(subjectNameFilter : All) {\r\n"
                +"  id \r\n"
                +"  subjectName \r\n"
                +"  marksObtained \r\n"
                +"  } \r\n"
                +"  fullName \r\n"
                +"  } \r\n"
                +"}";
        GraphQLRequest graphQLRequest = GraphQLRequest.builder()
                .query(queryStr).variables(variables).build();
        GraphQLResponse graphQLResponse = graphQLWebClient.post(graphQLRequest).block();
        return graphQLResponse.get("student", StudentResponse.class);
    }

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        Map<String, CreateStudentRequest> variables = new HashMap<>();
        variables.put("createStudentRequest", createStudentRequest);
        String mutationStr = "";
        GraphQLRequest graphQLRequest = GraphQLRequest.builder()
                .query(mutationStr).variables(variables).build();
        GraphQLResponse graphQLResponse = graphQLWebClient.post(graphQLRequest).block();
        return graphQLResponse.get("createStudentRequest", StudentResponse.class);
    }
}
