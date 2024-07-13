package org.example.service.strategy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.model.Problem;

import java.util.List;

@NoArgsConstructor
public abstract class FilterStrategy {
    String attribute;
    public abstract List<Problem> filter(List<Problem>problems);
}
