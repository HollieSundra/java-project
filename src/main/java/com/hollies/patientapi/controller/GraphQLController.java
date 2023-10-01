package com.hollies.patientapi.controller;

import org.apache.catalina.connector.Response;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graphql.GraphQL;

@RestController
@RequestMapping("/graphql")
public class GraphQLController {
    @Autowired
    private GraphQL graphQL;

    @PostMapping
    public ResponseEntity<Object> executeQuery(@RequestBody String query) {
        ExcutionResult excutionResult;

        try {
            executionResult = graphQL.execute(query);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("data", excutionResult.getData());

            if (!excutionResult.getErrors().isEmpty()) {
                resultMap.put("errors", excutionResult.getErrors());
            }

            return ResponseEntity.ok(resultMap);
        } catch (Exception e) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMap);
        }
    }

}
