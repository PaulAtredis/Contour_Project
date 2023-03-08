package com.example.Project.Controller;

import com.example.Project.Entities.Team_Entity;
import com.example.Project.Services.Team_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



    @RestController
    public class Team_Controller {
        @Autowired
        private Team_Service teamService;

        //@GetMapping("/team")
        @GetMapping(value = "/team",consumes = {"application/xml","application/json"})
        private List<Team_Entity> getAll() {
            return teamService.getAll();
        }

        //@GetMapping("/team/{id}")
        @GetMapping(value = "/team/{id}",consumes = {"application/xml","application/json"})
        private Team_Entity getByID(@PathVariable int id) {

            return teamService.getByID(id);
        }

        //@PostMapping("/team")
        @PostMapping(value = "/team",consumes = {"application/xml","application/json"})
        private Team_Entity add(@RequestBody Team_Entity teamEntity) {
            return teamService.addOrUpdate(teamEntity);
        }

        //@PutMapping("/team/{id}")
        @PutMapping(value = "/team/{id}",consumes = {"application/xml","application/json"})
        private Team_Entity update(@PathVariable int id, @RequestBody Team_Entity teamEntity) {
            teamEntity.setTeamId(id);
            return teamService.addOrUpdate(teamEntity);
        }

        //@DeleteMapping("/team/{id}")
        @DeleteMapping(value = "/team/{id}",consumes = {"application/xml","application/json"})
        private void delete(@PathVariable int id) {
            teamService.deleteByID(id);
        }

    }

