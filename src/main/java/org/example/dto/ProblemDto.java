package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Difficulty;
import org.example.model.Tag;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProblemDto {
    private List<Tag> tags;
    private String description;
    private Difficulty difficulty;
    private int score;
}
