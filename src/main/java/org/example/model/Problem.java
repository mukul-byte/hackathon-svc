package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.dto.ProblemDto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Problem {
    private int id;
    private List<Tag> tags;
    private String description;
    private Difficulty difficulty;
    private int score;
    private List<Integer> usersSolved = new ArrayList<Integer>();

    public Problem(int id, ProblemDto problemDto) {
        this.tags = problemDto.getTags();
        this.description = problemDto.getDescription();
        this.difficulty = problemDto.getDifficulty();
        this.score = problemDto.getScore();
        this.id = id;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "score=" + score +
                ", difficulty=" + difficulty +
                ", description='" + description + '\'' +
                ", tags=" + tags +
                ", id=" + id +
                '}';
    }
}
