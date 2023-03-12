package com.example.Project.Dto;


import com.example.Project.Entities.Matches_Entity;
import com.example.Project.Entities.Team_Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public class Team_Dto {
        private Team_Entity teamEntity;

        public Team_Entity getTeamEntity() {
            return teamEntity;
        }

        public void setTeamEntity(Team_Entity teamEntity) {
            this.teamEntity = teamEntity;
        }
        private List<Matches_Entity> matches;

    }


