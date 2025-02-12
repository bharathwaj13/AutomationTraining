package org.onboard.java8.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private String responseBody;
    private int statusCode;
    private String responseType;
}
