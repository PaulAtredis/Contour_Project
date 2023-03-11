package com.example.Project.Services;

import com.example.Project.Adapter.MatchesAdapter;
import com.example.Project.Adapter.TourAdapter;
import com.example.Project.Dto.Tour_Dto;
import com.example.Project.Entities.Matches_Entity;
import com.example.Project.Entities.Tour_Entity;
import com.example.Project.Repositries.Matches_Repo;
import com.example.Project.Repositries.Tour_Repo;
import com.example.Project.Service_Interfaces.Tour_Serv_Interface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Tour_Serv_Imp implements Tour_Serv_Interface {
@Autowired
    Tour_Repo tourRepo;
@Autowired
Matches_Repo matchesRepo;
@Autowired
    ModelMapper modelMapper;

    private List<Tour_Dto> tourDtoList = new ArrayList<>();



    public List<Tour_Dto> getTourDtoList() {
        return tourDtoList;
    }

    public void setTourDtoList(List<Tour_Dto> tourDtoList) {
        this.tourDtoList = tourDtoList;
    }

    @Override
    public List<Tour_Dto> findAll() {
        List<Tour_Entity> tourEntityList = tourRepo.findAll();
        List<Tour_Dto> tour_dtoList = new ArrayList<>();
        for ( Tour_Entity e: tourEntityList) {
            tour_dtoList.add(modelMapper.map(e, Tour_Dto.class));
        }

        return tour_dtoList;
    }

    @Override
    public Tour_Dto findById(Long tour_id) {
        Tour_Entity tour_entity =tourRepo.findById(tour_id).orElseThrow(()->new RuntimeException("No such ID exists"));
        Tour_Dto tour_dto=modelMapper.map(tour_entity, Tour_Dto.class);
        return tour_dto;
    }

    @Override
    public Tour_Dto findBy_TourName(String tourName) {
        Tour_Entity tour_entity = tourRepo.findByTourName(tourName);
        Tour_Dto tour_dto=modelMapper.map(tour_entity,Tour_Dto.class);
        return tour_dto;
    }


    @Override
    public Tour_Dto addTour(Tour_Dto tourDto) {

        Tour_Entity s= tourRepo.save(modelMapper.map(tourDto,Tour_Entity.class));
        return tourDto;
    }

    @Override
    public void deleteTour(Long tour_id) {
        tourRepo.deleteById(tour_id);

    }

    @Override
    public Tour_Dto updateTour(long tour_id, Tour_Dto tourDto) {
       Tour_Entity tourEntity= tourRepo.findById(tour_id).orElseThrow(()->new RuntimeException("No such id exists"));
        Tour_Dto tour_dto=modelMapper.map(tourEntity,Tour_Dto.class);
        tourEntity.setTour_year(tourDto.getTour_year());
        tourEntity.setTour_st_date(tourDto.getTour_st_date());
        tourEntity.setTour_end_date(tourDto.getTour_end_date());
        tourRepo.save(tourEntity);
       return tour_dto;
    }

    public Tour_Dto updateMatchesWithTour(Tour_Dto tourDto){
        TourAdapter tourAdapter=new TourAdapter();
        MatchesAdapter matchesAdapter=new MatchesAdapter();

        List<Matches_Entity> matches_entityList = new ArrayList<>();
        tourDto.getMatchesDtoList().forEach(matchesDto -> {
         matches_entityList.add(matchesRepo.findByMatchName(matchesDto.getMatchName()));
        });
      Tour_Entity tour_entity=tourRepo.findByTourName(tourAdapter.convDtoToDao(tourDto).getTourName());
      matches_entityList.forEach(matchesEntity -> {
          matchesEntity.setTourEntity(tour_entity);
          tour_entity.addMatches(matchesEntity);

      });

      tourRepo.save(tour_entity);

      return tourAdapter.convDaoToDto(tour_entity);
  }
}
