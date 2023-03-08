package com.example.Project.Entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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


        @ManyToMany(mappedBy = "teamEntity",fetch = FetchType.LAZY)
        private Set<Matches_Entity> matches;

    public Set<Matches_Entity> getMatches() {
        return matches;
    }

    public void setMatches(Set<Matches_Entity> matches) {
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

