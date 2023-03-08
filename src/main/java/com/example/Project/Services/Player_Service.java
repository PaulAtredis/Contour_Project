package com.example.Project.Services;

import com.example.Project.Entities.Player_Entity;
import com.example.Project.Repositries.Player_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class Player_Service {
        @Autowired
        private Player_Repo playerRepo;

        public Player_Entity addOrUpdate(Player_Entity playerEntity) {
            return playerRepo.save(playerEntity);

        }

        public List<Player_Entity> getAll() {
            return playerRepo.findAll();
        }

        public boolean deleteByID(int id) {
            playerRepo.deleteById(id);
            return true;
        }

        public Player_Entity getByID(int id) {
            return playerRepo.findById(id).get();
        }
    }


