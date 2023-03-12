package com.example.Project.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "match_name")
    private String matchName;


    @ManyToMany
    @JoinTable(name = "match_by_team", joinColumns = {@JoinColumn(name = "match_id")},
            inverseJoinColumns ={ @JoinColumn(name = "teamId")})
    @JsonIgnore
    private List<Team_Entity> teamEntity;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tour_id")
    private Tour_Entity tourEntity;


    public Tour_Entity getTourEntity() {
        return tourEntity;
    }
    public void setTourEntity(Tour_Entity tour_entity) {
        this.tourEntity = tour_entity;
    }

    public List<Team_Entity> getTeamEntity() {
        return teamEntity;
    }

    public void setTeamEntity(List<Team_Entity> teamEntity) {
        this.teamEntity = teamEntity;
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
