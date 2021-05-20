package com.project.developer.cpa.model;

import lombok.Data;

import java.util.List;

@Data
public class ApiErrorResponse {
    private List<String> errors;
}
