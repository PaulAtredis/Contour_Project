package com.example.Project.Adapter;

import com.example.Project.Dto.Matches_Dto;
import com.example.Project.Entities.Matches_Entity;

public class MatchesAdapter {
    public Matches_Entity convDtoToDao(Matches_Dto matchesDto){


    Matches_Entity matchesEntity=new Matches_Entity();

    matchesEntity.setMatch_id(matchesDto.getMatch_id());
    matchesEntity.setStart_time(matchesDto.getStart_time());
    matchesEntity.setEnd_time(matchesDto.getStart_time());
    matchesEntity.setMatchName(matchesDto.getMatchName());

     //matchesEntity.setTourEntity(matchesDto.getTourDtoList());
    return matchesEntity;
}


    public Matches_Dto convDaoToDto(Matches_Entity matchesEntity){
        Matches_Dto matches_dto=new Matches_Dto();

        matches_dto.setMatch_id(matchesEntity.getMatch_id());
        matches_dto.setEnd_time(matchesEntity.getEnd_time());
        matches_dto.setMatchName(matchesEntity.getMatchName());
        matches_dto.setStart_time(matchesEntity.getStart_time());

        //matches_dto.setTourDtoList(matchesEntity.getTourEntity());

        return matches_dto;
    }
}
