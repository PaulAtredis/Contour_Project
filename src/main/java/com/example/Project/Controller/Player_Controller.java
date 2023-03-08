package com.example.Project.Controller;

import com.example.Project.Entities.Player_Entity;
import com.example.Project.Services.Player_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    public class Player_Controller {
        @Autowired
        private Player_Service playerService;

        @GetMapping("/player")
        private List<Player_Entity> getAll() {
            return playerService.getAll();
        }

        @GetMapping("/player/{id}")
        private Player_Entity getByID(@PathVariable int id) {

            return playerService.getByID(id);
        }
        @PostMapping("/player")
        private Player_Entity add(@RequestBody Player_Entity playerEntity) {
            return playerService.addOrUpdate(playerEntity);
        }
        @PutMapping("/player/{id}")
        private Player_Entity update(@PathVariable int id, @RequestBody Player_Entity playerEntity) {
            playerEntity.setPid(id);
            return playerService.addOrUpdate(playerEntity);
        }
        @DeleteMapping("/player/{id}")
        private void delete(@PathVariable int id) {
            playerService.deleteByID(id);
        }
    }


