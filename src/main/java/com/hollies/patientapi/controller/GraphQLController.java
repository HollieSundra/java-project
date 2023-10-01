package com.hollies.patientapi.controller;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/graphql")
public class GraphQLController {

    @Autowired
    private GraphQL graphQL;

    @PostMapping
    public ResponseEntity<Object> executeQuery(@RequestBody String query) {
        
        try {
            ExecutionResult executionResult = graphQL.execute(query);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("data", executionResult.getData());

            if (!executionResult.getErrors().isEmpty()) {
                resultMap.put("errors", executionResult.getErrors());
            }

            return ResponseEntity.ok(resultMap);
        } catch (Exception e) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMap);
        }
    }

}
