package com.example.Project.Entities;

import javax.persistence.*;
import java.util.Set;

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



    @ManyToMany
    @JoinTable(name = "match_by_team",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "teamId"))
    private Set<Team_Entity> teamEntity;

    public Set<Team_Entity> getTeamEntity() {
        return teamEntity;
    }

    public void setTeamEntity(Set<Team_Entity> teamEntity) {
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
}
