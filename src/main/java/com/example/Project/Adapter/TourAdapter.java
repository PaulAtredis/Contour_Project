package com.example.Project.Adapter;

import com.example.Project.Dto.Tour_Dto;
import com.example.Project.Entities.Tour_Entity;

public class TourAdapter {
    public Tour_Entity convDtoToDao(Tour_Dto tourDto){


        Tour_Entity tourEntity=new Tour_Entity();

        tourEntity.setTour_st_date(tourDto.getTour_st_date());
        tourEntity.setTour_end_date(tourDto.getTour_end_date());
        tourEntity.setTour_id(tourDto.getTour_id());
        tourEntity.setTour_year(tourDto.getTour_year());
        tourEntity.setTourName(tourDto.getTourName());

//        MatchesAdapter matchesAdapter = new MatchesAdapter();
//        matchesAdapter.convDtoToDao(tourDto.getMatchesDtoList())
//       // tourEntity.setMatches(tourDto.getMatchesDtoList());
        return tourEntity;
    }


    public Tour_Dto convDaoToDto(Tour_Entity tourEntity){
        Tour_Dto tour_dto=new Tour_Dto();

        tour_dto.setTour_year(tourEntity.getTour_year());
        tour_dto.setTourName(tourEntity.getTourName());
        tour_dto.setTour_end_date(tourEntity.getTour_end_date());
        tour_dto.setTour_st_date(tourEntity.getTour_st_date());
        tour_dto.setTour_id(tourEntity.getTour_id());

        //tour_dto.setMatchesDtoList(tourEntity.getMatches());

        return tour_dto;
}}
