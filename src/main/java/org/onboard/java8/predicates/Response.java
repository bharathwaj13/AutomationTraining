package org.onboard.java8.predicates;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {

    private String body;
    private int statusCode;
    private String responseType;
}
