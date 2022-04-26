package com.example.footballmatchprediction.Repository;

import com.example.footballmatchprediction.mapper.PredictionMaaper;
import com.example.footballmatchprediction.mapper.RankingMapper;
import com.example.footballmatchprediction.model.PredictionResult;
import com.example.footballmatchprediction.model.StandingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.StringJoiner;

@Repository

public class PredictionRepository {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<PredictionResult> getPredictionResult(String monthInput,String yearInput){
//        String months = "'%-" + monthInput + "-" + yearInput + "%'";
        String months = "'%" + yearInput + "-" + monthInput + "%'";
        String selectDate = "a.\"Date\"";
        StringJoiner sql = new StringJoiner(" ")
                .add("SELECT")
                .add("a.\"index\",")
                .add(selectDate)
                .add(",a.\"HomeTeam\"" +
                        ",a.\"AwayTeam\",a.\"FTHG\",a.\"FTAG\",a.\"FTR\",a.\"prob_A\",a.\"prob_D\",a.\"prob_H\"")
                .add("FROM")
                .add("prediction_results a")
                .add("WHERE")
                .add("a.\"Date\"")
                .add("LIKE")
                .add(months)
                .add(" ");

//        String sql = "SELECT a.\"Date\",a.HomeTeam,a.AwayTeam,a.FTHG,a.FTAG,a.FTR,a.prob_A,a.prob_D,a.prob_H "+
//                "FROM prediction_results a "+
//                "WHERE"+
//                "a.date LIKE" +
//                "month";


//        String sql = "SELECT a.date FROM prediction_results a WHERE a.date LIKE :month ";
//        String monthSearch = "%" + monthInput + "%";
//
//        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//        mapSqlParameterSource.addValue("month",monthInput);

        return  namedParameterJdbcTemplate.query(sql.toString(),new PredictionMaaper());


    }

    public List<StandingResponse> getStanding(){
        String sql = "SELECT * FROM standing_table";

        return namedParameterJdbcTemplate.query(sql,new RankingMapper());
    }
}
