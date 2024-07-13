package org.example.service;

import org.example.factory.FilterFactory;
import org.example.model.Filter;
import org.example.model.FilterName;
import org.example.model.Problem;
import org.example.service.strategy.FilterStrategy;

import java.util.List;

public class FilterService {

//    List<Filter> filters = new ArrayList<>();

    public List<Problem> filterBy(List<Problem> problems, List<Filter> filters){
        for(Filter f: filters){
            FilterStrategy filterStrategy = FilterFactory.getFilterStrategy(f.getName(), f.getAttribute());
            if(filterStrategy == null){
                continue;
            }
            problems = filterStrategy.filter(problems);
        }

        return problems;
    }
}
