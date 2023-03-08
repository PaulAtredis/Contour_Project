package com.example.Project.Services;

import com.example.Project.Entities.Team_Entity;
import com.example.Project.Repositries.Team_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class Team_Service {
        @Autowired
        private Team_Repo teamRepo;

        public Team_Entity addOrUpdate(Team_Entity teamEntity) {
            return teamRepo.save(teamEntity);

        }

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


