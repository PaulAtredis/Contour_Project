package com.example.Project.Services;

import com.example.Project.Dto.Matches_Dto;
import com.example.Project.Entities.Matches_Entity;
import com.example.Project.Repositries.Matches_Repo;
import com.example.Project.Repositries.Team_Repo;
import com.example.Project.Service_Interfaces.Matches_Serv_Interface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Matches_Serv_Imp implements Matches_Serv_Interface {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    Matches_Repo matchesRepo;
    @Autowired
    Team_Repo teamRepo;

    private List<Matches_Dto> matchesDtoList = new ArrayList<>();

    public List<Matches_Dto> getMatchesDtoList() {
        return matchesDtoList;
    }

    public void setMatchesDtoList(List<Matches_Dto> matchesDtoList) {
        this.matchesDtoList = matchesDtoList;
    }

    @Override
    public List<Matches_Dto> findAll() {
        List<Matches_Entity> matches_entityList = matchesRepo.findAll();
        List<Matches_Dto> matchesDtoList = new ArrayList<>();
        for ( Matches_Entity e: matches_entityList) {
            matchesDtoList.add(modelMapper.map(e, Matches_Dto.class));
        }

        return matchesDtoList;
    }

    @Override
    public Matches_Dto findById(Long match_id) {

            Matches_Entity matchesEntity =matchesRepo.findById(match_id).orElseThrow(()->new RuntimeException("No such ID exists"));
            Matches_Dto matches_dto=modelMapper.map(matchesEntity, Matches_Dto.class);
            return matches_dto;
        }

    @Override
    public Matches_Dto findBy_MatchName(String matchName) {
        Matches_Entity matches_entity = matchesRepo.findByMatchName(matchName);
        Matches_Dto matchesDto=modelMapper.map(matches_entity,Matches_Dto.class);
        return matchesDto;
    }

    @Override
    public Matches_Dto addMatch(Matches_Dto matchesDto) {
        Matches_Entity s= matchesRepo.save(modelMapper.map(matchesDto,Matches_Entity.class));
        return matchesDto;
    }

//    public Matches_Entity addMatchesWithTeams(Matches_Dto matchesDto) {
//        Matches_Entity matches_entity =modelMapper.map(matchesDto, Matches_Entity.class);
//        List<Team_Entity> lst= matchesDto.getTeamEntity();
//
//            teamRepo.saveAll(matchesDto.getTeamEntity());
//            return matchesRepo.save(matches_entity);
//        }




    @Override
    public void deleteMatch(Long match_id) {
        matchesRepo.deleteById(match_id);
    }

    @Override
    public Matches_Dto updateMatch(long match_id, Matches_Dto matchesDto) {
        Matches_Entity matchesEntity= matchesRepo.findById(match_id).orElseThrow();
        Matches_Dto matches_dto=modelMapper.map(matchesEntity,Matches_Dto.class);
        matchesEntity.setEnd_time(matchesDto.getEnd_time());
        matchesEntity.setStart_time(matchesDto.getStart_time());
        matchesRepo.save(matchesEntity);
        return matches_dto;
    }

}



