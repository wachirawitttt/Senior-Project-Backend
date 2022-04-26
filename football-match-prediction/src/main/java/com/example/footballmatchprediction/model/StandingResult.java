package com.example.footballmatchprediction.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class StandingResult {
    private List<StandingResponse> standingResponseList;
}
