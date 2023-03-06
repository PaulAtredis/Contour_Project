package com.example.Project.Entities;

import javax.persistence.*;

@Entity
@Table(name = "matches")
public class Matches_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "match_id")
    private long match_id;
    @Column(name = "start_time")
    private long start_time;
    @Column(name = "end_time")
    private long end_time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private Tour_Entity tourEntity;

    public Tour_Entity getTourEntity() {
        return tourEntity;
    }

    public void setTourEntity(Tour_Entity tourEntity) {
        this.tourEntity = tourEntity;
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
}
