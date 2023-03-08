package com.example.Project.Controller;

import com.example.Project.Entities.Team_Entity;
import com.example.Project.Services.Team_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



    @RestController
    @RequestMapping("/team")
    public class Team_Controller {
        @Autowired
        private Team_Service teamService;

        @GetMapping
        private List<Team_Entity> getAll() {
            return teamService.getAll();
        }

        @GetMapping("/{id}")
        private Team_Entity getByID(@PathVariable int id) {

            return teamService.getByID(id);
        }

        @PostMapping
        private Team_Entity add(@RequestBody Team_Entity teamEntity) {
            return teamService.addOrUpdate(teamEntity);
        }

        @PutMapping("/{id}")
        private Team_Entity update(@PathVariable int id, @RequestBody Team_Entity teamEntity) {
            teamEntity.setTeamId(id);
            return teamService.addOrUpdate(teamEntity);
        }

        @DeleteMapping("/{id}")
        private void delete(@PathVariable int id) {
            teamService.deleteByID(id);
        }

    }

