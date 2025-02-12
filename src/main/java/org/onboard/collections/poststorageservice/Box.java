package org.onboard.collections.poststorageservice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Box {

    private String sender;
    private String recipient;
    private double weight;
    private double volume;
    private BigDecimal cost;
    private String city;
    private int office;
}
