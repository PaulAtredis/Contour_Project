package com.example.Project.Entities;

import javax.persistence.*;

@Entity
@Table(name = "tournament")
public class Tour_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tournament_id")
    private long tour_id;

    @Column(name = "start_date")
    private long tour_st_date;

    @Column(name = "end_date")
    private long tour_end_date;


    @Column(name = "year")
    private long tour_year;

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
}
