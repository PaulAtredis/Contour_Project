package com.example.Project.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Entity
    public class Team_Entity {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "teamId", nullable = false)
        private int teamId;
        private String teamName;

        @OneToMany(targetEntity = Player_Entity.class,cascade = CascadeType.ALL)
        @JoinColumn(name="p_fk", referencedColumnName = "teamId")
        private List<Player_Entity> playerEntity;


        @ManyToMany(mappedBy = "teamEntity",cascade = {CascadeType.ALL})
        @JsonIgnore
        private List<Matches_Entity> matches;

    public List<Matches_Entity> getMatches() {
        return matches;
    }

    public void setMatches(List<Matches_Entity> matches) {
        this.matches = matches;
    }

    public int getTeamId() {
            return teamId;
        }
        public void setTeamId(int teamId) {
            this.teamId = teamId;
        }
        public String getTeamName() {
            return teamName;
        }
        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }
        public List<Player_Entity> getPlayerEntity() {
            return playerEntity;
        }
        public void setPlayerEntity(List<Player_Entity> playerEntity) {
            this.playerEntity = playerEntity;
        }



    }

