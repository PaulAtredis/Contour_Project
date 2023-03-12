package com.example.Project.Dto;

import com.example.Project.Entities.Team_Entity;

import java.util.List;

public class Matches_Dto {
    private long match_id;
    private long start_time;
    private long end_time;
    private String matchName;
    private List<Tour_Dto> tourDtoList;
    private List<Team_Entity> teamEntity;


    public List<Team_Entity> getTeamEntity() {
        return teamEntity;
    }
    public void setTeamEntity(List<Team_Entity> teamEntity) {
        this.teamEntity = teamEntity;
    }

    public List<Tour_Dto> getTourDtoList() {
        return tourDtoList;
    }

    public void setTourDtoList(List<Tour_Dto> tourDtoList) {
        this.tourDtoList = tourDtoList;
    }

    public long getMatch_id() {
        return match_id;
    }

    public void setMatch_id(long match_id) {
        this.match_id = match_id;
    }

    public long getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(long end_time) {
        this.end_time = end_time;
    }
    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }


}
