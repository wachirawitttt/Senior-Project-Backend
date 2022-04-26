package com.example.footballmatchprediction.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class StandingResponse {
    private int position;
    private String teamName;
    private int pts;
    private int goal_diff;
    private String win_rate;
}
