package com.example.footballmatchprediction.service;


import com.example.footballmatchprediction.Repository.PredictionRepository;
import com.example.footballmatchprediction.model.PredictionResponse;
import com.example.footballmatchprediction.model.PredictionResult;
import com.example.footballmatchprediction.model.StandingResponse;
import com.example.footballmatchprediction.model.StandingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PredictionService {
    @Autowired
    private PredictionRepository predictionRepository;

    public PredictionResponse getPredictionResult(String month,String year){
//        List<PredictionResult> predictionResultList = predictionRepository.getPredictionResult(month,year);
//        int size = predictionResultList.size();
//        List<PredictionResponse> predictionResponse = new ArrayList<>(predictionResultList.size());
//        for(int i = 0;i<predictionResultList.size();i++) {
//            PredictionResponse predictionResponse1 = new PredictionResponse();
//            predictionResponse1.setDate(predictionResultList.get(i).getDate())
//                    .setHomeTeam(predictionResultList.get(i).getHomeTeam())
//                    .setAwayTeam(predictionResultList.get(i).getAwayTeam())
//                    .setFtag(predictionResultList.get(i).getFtag())
//                    .setFthg(predictionResultList.get(i).getFthg())
//                    .setFtr(predictionResultList.get(i).getFtr())
//                    .setProb_A(convertPercentage(predictionResultList.get(i).getProb_A()))
//                    .setProb_D(convertPercentage(predictionResultList.get(i).getProb_D()))
//                    .setProb_H(convertPercentage(predictionResultList.get(i).getProb_H()))
//                    .setIndexs(i);
//            predictionResponse.add(predictionResponse1);
//        }
        List<PredictionResult> predictionResultList = predictionRepository.getPredictionResult(month,year);
        PredictionResponse predictionResponse = new PredictionResponse();

        predictionResponse.setPredictionResultList(predictionResultList);

        return predictionResponse;

    }

    public StandingResult getRankingResult(){
        List<StandingResponse> standingResponseList = predictionRepository.getStanding();
        StandingResult standingResult = new StandingResult();
        standingResult.setStandingResponseList(standingResponseList);
        return standingResult;
    }

    public String convertPercentage(float x)
    {
        String percent = (x*100)+"%";
        return percent;
    }
//    public List<PredictionResult> mapToSavingTransaction(List<PredictionResult> savingDetails) {
//        return savingDetails.stream().map(savingDetail ->
//                new SavingTransaction()
//                        .setSavingId(savingDetail.getSavingId())
//                        .setCreatedDateTime(savingDetail.getDateTime())
//                        .setDepositAmount(savingDetail.getDepositamt()))
//                .collect(Collectors.toList());
//
//    }
}
