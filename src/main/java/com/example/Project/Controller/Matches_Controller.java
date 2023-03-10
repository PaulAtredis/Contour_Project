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

    @GetMapping("/matches")
    public ResponseEntity<List<Matches_Dto>> getMatches() {
        return new ResponseEntity<>(matchesServImp.findAll(), HttpStatus.OK);
    }

    @GetMapping("/matches/{match_id}")
    public ResponseEntity<Matches_Dto> findMatch_ByID(@PathVariable Long match_id) {
        return new ResponseEntity<>(matchesServImp.findById(match_id),HttpStatus.OK);
    }

    @GetMapping("/matches/name/{matchName}")
    public ResponseEntity<Matches_Dto> findBy_MatchName(@PathVariable String matchName) {
        return new ResponseEntity<>(matchesServImp.findBy_MatchName(matchName),HttpStatus.OK);
    }
    @PostMapping("/matches")
    public ResponseEntity<Matches_Dto> addMatch(@RequestBody Matches_Dto tourDto) {

        matchesServImp.addMatch(tourDto);
        return new ResponseEntity<Matches_Dto>(HttpStatus.OK);
    }

    @DeleteMapping("/matches/{match_id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long match_id) {
        matchesServImp.deleteMatch(match_id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/matches/{match_id}")
    public ResponseEntity<Matches_Dto> updateMatch(@PathVariable Long match_id, @RequestBody Matches_Dto matchesDto) {
        matchesServImp.updateMatch(match_id, matchesDto);
        return ResponseEntity.ok(matchesDto);


    }
}
