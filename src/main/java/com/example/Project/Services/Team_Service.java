package com.example.Project.Services;

import com.example.Project.Entities.Team_Entity;
import com.example.Project.Repositries.Matches_Repo;
import com.example.Project.Repositries.Team_Repo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class Team_Service {
        @Autowired
        private Team_Repo teamRepo;
        @Autowired
        Matches_Repo matchesRepo;
        @Autowired
        ModelMapper modelMapper;

        public Team_Entity addOrUpdate(Team_Entity teamEntity) {
            return teamRepo.save(teamEntity);

        }

//        public  Team_Entity addTeamswithMatches(Team_Dto teamDto){
//            Team_Entity entity =modelMapper.map(teamDto, Team_Entity.class);
//            List<Matches_Entity> lst= teamDto.getMatches();
//
//                matchesRepo.saveAll(teamDto.getMatches());
//                return teamRepo.save(entity);
//
//
//        }

        public List<Team_Entity> getAll() {
            return teamRepo.findAll();
        }

        public boolean deleteByID(int id) {
            teamRepo.deleteById(id);
            return true;
        }

        public Team_Entity getByID(int id) {
            return teamRepo.findById(id).get();
        }
    }


