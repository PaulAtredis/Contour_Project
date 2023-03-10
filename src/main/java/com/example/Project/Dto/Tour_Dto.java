package com.example.Project.Dto;

import java.util.List;

public class Tour_Dto {

    private long tour_id;
    private long tour_st_date;
    private long tour_end_date;
    private long tour_year;
    private String tourName;
    private List<Matches_Dto> matchesDtoList;

    public List<Matches_Dto> getMatchesDtoList() {
        return matchesDtoList;
    }

    public void setMatchesDtoList(List<Matches_Dto> matchesDtoList) {
        this.matchesDtoList = matchesDtoList;
    }

    public long getTour_year() {
        return tour_year;
    }

    public void setTour_year(long tour_year) {
        this.tour_year = tour_year;
    }

    public long getTour_id() {
        return tour_id;
    }

    public void setTour_id(long tour_id) {
        this.tour_id = tour_id;
    }

    public long getTour_st_date() {
        return tour_st_date;
    }

    public void setTour_st_date(long tour_st_date) {
        this.tour_st_date = tour_st_date;
    }

    public long getTour_end_date() {
        return tour_end_date;
    }

    public void setTour_end_date(long tour_end_date) {
        this.tour_end_date = tour_end_date;
    }
    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }




}
