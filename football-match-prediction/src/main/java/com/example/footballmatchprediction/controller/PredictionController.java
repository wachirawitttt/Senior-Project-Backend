package com.example.footballmatchprediction.controller;


import com.example.footballmatchprediction.model.PredictionResponse;
import com.example.footballmatchprediction.model.StandingResponse;
import com.example.footballmatchprediction.model.StandingResult;
import com.example.footballmatchprediction.service.PredictionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@Slf4j
public class PredictionController {
    @Autowired
    private PredictionService predictionService;

    @GetMapping("/v1/prediction-result/prediction-detail")
    public ResponseEntity <PredictionResponse> getPredictionDetail(
            @RequestParam(required = false) String month,String year
    ){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(predictionService.getPredictionResult(month,year));
    }

    @GetMapping("/v1/prediction-result/ranking-datail")
    public ResponseEntity <StandingResult> getRankingDetail(

    ){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(predictionService.getRankingResult());
    }

}
