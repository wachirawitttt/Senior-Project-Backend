package com.example.footballmatchprediction.mapper;

import com.example.footballmatchprediction.model.PredictionResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PredictionMaaper implements RowMapper<PredictionResult> {
    @Override
    public PredictionResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PredictionResult()
                .setIndexs(rs.getInt("index"))
                .setDate(rs.getString("Date"))
                .setHomeTeam(rs.getString("homeTeam"))
                .setAwayTeam(rs.getString("awayTeam"))
                .setFthg(rs.getInt("FTHG"))
                .setFtag(rs.getInt("FTAG"))
                .setFtr(rs.getString("FTR"))
                .setProb_A(rs.getFloat("prob_A"))
                .setProb_D(rs.getFloat("prob_D"))
                .setProb_H(rs.getFloat("prob_H"));
    }
}
