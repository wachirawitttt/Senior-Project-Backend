package com.example.footballmatchprediction.mapper;

import com.example.footballmatchprediction.model.StandingResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RankingMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new StandingResponse()
                .setPosition(rs.getInt("index"))
                .setTeamName(rs.getString("Team"))
                .setPts(rs.getInt("Points"))
                .setGoal_diff(rs.getInt("Goal_Diff"))
                .setWin_rate(rs.getString("Win_Rate"));
    }
}
