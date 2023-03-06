package com.example.Project.Controller;

import com.example.Project.Dto.Matches_Dto;
import com.example.Project.Services.Matches_Serv_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class Matches_Controller {

    @Autowired
    Matches_Serv_Imp matchesServImp;

    @GetMapping("/tournament/matches")
    public ResponseEntity<List<Matches_Dto>> getMatches() {
        return new ResponseEntity<>(matchesServImp.findAll(), HttpStatus.OK);
    }

    @GetMapping("/tournament/matches/{match_id}")
    public ResponseEntity<Void> findMatch_ByID(@PathVariable Long match_id) {
        matchesServImp.findById(match_id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/tournament/matches")
    public ResponseEntity<Matches_Dto> addMatch(@RequestBody Matches_Dto tourDto) {

        matchesServImp.addMatch(tourDto);
        return new ResponseEntity<Matches_Dto>(HttpStatus.OK);
    }

    @DeleteMapping("/tournament/matches/{match_id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long match_id) {
        matchesServImp.deleteMatch(match_id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/tournament/matches/{match_id}")
    public ResponseEntity<Matches_Dto> updateMatch(@PathVariable Long match_id, @RequestBody Matches_Dto matchesDto) {
        matchesServImp.updateMatch(match_id, matchesDto);
        return ResponseEntity.ok(matchesDto);


    }
}
