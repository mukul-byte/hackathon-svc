package org.example.factory;

import org.example.model.FilterName;
import org.example.service.strategy.FilterByDifficulty;
import org.example.service.strategy.FilterByScore;
import org.example.service.strategy.FilterStrategy;

public class FilterFactory {

    public static FilterStrategy getFilterStrategy(FilterName f, String attribute) {
        switch (f){
            case SCORE:
                return new FilterByScore(attribute);

            case DIFFICULTY:
                return new FilterByDifficulty(attribute);

            default:
                return null;
        }
    }
}
