package com.example.Project.Controller;

import com.example.Project.Dto.Tour_Dto;
import com.example.Project.Services.Tour_Serv_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Tour_Control {

    @Autowired
    Tour_Serv_Imp tourServImp;


    @GetMapping("/tournament")
    public ResponseEntity<List<Tour_Dto>> getTournament() {
        return new ResponseEntity<>(tourServImp.findAll(), HttpStatus.OK);
    }

    @GetMapping("/tournament/{tour_id}")
    public ResponseEntity<Tour_Dto> findTournament_ByID(@PathVariable Long tour_id) {
    return new ResponseEntity<>(tourServImp.findById(tour_id),HttpStatus.OK);
    }



    @PostMapping("/tournament")
    public ResponseEntity<Tour_Dto> addTournament(@RequestBody Tour_Dto tourDto) {
        tourServImp.addTour(tourDto);
        return new ResponseEntity<Tour_Dto>(HttpStatus.OK);
    }
    @GetMapping("/tournament/name/{tourName}")
    public ResponseEntity<Tour_Dto> findBy_MatchName(@PathVariable String tourName) {
        return new ResponseEntity<>(tourServImp.findBy_TourName(tourName),HttpStatus.OK);
    }

    @PutMapping("/tournament/matches")
    public ResponseEntity<Tour_Dto> upMatchesWithTour(@RequestBody Tour_Dto tourDto){
        tourServImp.updateMatchesWithTour(tourDto);
        return new ResponseEntity<Tour_Dto>(HttpStatus.OK);
    }

    @DeleteMapping("/tournament/{tour_id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable Long tour_id) {
        tourServImp.deleteTour(tour_id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/tournament/{tour_id}")
    public ResponseEntity<Tour_Dto> updateTournament(@PathVariable Long tour_id, @RequestBody Tour_Dto tourDto) {
        tourServImp.updateTour(tour_id, tourDto);
        return ResponseEntity.ok(tourDto);


    }
}