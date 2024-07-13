package org.example.service.strategy;

import org.example.model.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterByScore extends FilterStrategy{
    public FilterByScore(String attribute){
        try{
            int score = Integer.parseInt(attribute);
            //validations on score if needed
        } catch (Exception ex){
            //
        }
        this.attribute = attribute;
    }

    @Override
    public List<Problem> filter(List<Problem> problems) {
        List<Problem> filteredProblem = new ArrayList<Problem>();
        return problems.stream().filter(p->p.getScore()==Integer.parseInt(attribute)).collect(Collectors.toList());
    }
}
