package com.example.Project.Services;

import com.example.Project.Dto.Tour_Dto;
import com.example.Project.Entities.Tour_Entity;
import com.example.Project.Repositries.Tour_Repo;
import com.example.Project.Service_Interfaces.Tour_Serv_Interface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Tour_Serv_Imp implements Tour_Serv_Interface {
@Autowired
    Tour_Repo tourRepo;
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
    public List<Tour_Dto> findById(Long tour_id) {
        Optional<Tour_Entity> tour_entityList = Optional.of(tourRepo.findById(tour_id).orElseThrow(()->new RuntimeException("No such ID exists")));
        List<Tour_Dto> tour_dtoList=new ArrayList<>();
        tour_dtoList.add(modelMapper.map(tour_entityList, Tour_Dto.class));
        return tour_dtoList;
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
       Tour_Entity tourEntity= tourRepo.findById(tour_id).orElseThrow();
        Tour_Dto tour_dto=modelMapper.map(tourEntity,Tour_Dto.class);
        tourEntity.setTour_year(tourDto.getTour_year());
        tourEntity.setTour_st_date(tourDto.getTour_st_date());
        tourEntity.setTour_end_date(tourDto.getTour_end_date());
        tourRepo.save(tourEntity);
       return tour_dto;
    }
}
