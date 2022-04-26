package com.example.footballmatchprediction.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class PredictionResult {
    private int indexs;
    private String date;
    private String homeTeam;
    private String awayTeam;
    private int fthg;
    private int ftag;
    private String ftr;
    private float prob_A;
    private float prob_D;
    private float prob_H;

}
