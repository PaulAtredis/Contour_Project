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

        //@GetMapping("/player")
        @GetMapping(value = "/player",consumes = {"application/xml","application/json"})
        private List<Player_Entity> getAll() {
            return playerService.getAll();
        }

        //@GetMapping("/player/{id}")
        @GetMapping(value = "/player/{id}",consumes = {"application/xml","application/json"})
        private Player_Entity getByID(@PathVariable int id) {

            return playerService.getByID(id);
        }
        //@PostMapping("/player")
        @PostMapping(value = "/player",consumes = {"application/xml","application/json"})
        private Player_Entity add(@RequestBody Player_Entity playerEntity) {
            return playerService.addOrUpdate(playerEntity);
        }
        //@PutMapping("/player/{id}")
        @PutMapping(value = "/player/{id}",consumes = {"application/xml","application/json"})
        private Player_Entity update(@PathVariable int id, @RequestBody Player_Entity playerEntity) {
            playerEntity.setPid(id);
            return playerService.addOrUpdate(playerEntity);
        }
        //@DeleteMapping("/player/{id}")
        @DeleteMapping(value = "/player/{id}",consumes = {"application/xml","application/json"})
        private void delete(@PathVariable int id) {
            playerService.deleteByID(id);
        }
    }


