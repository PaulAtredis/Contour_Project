package com.example.Project.Service_Interfaces;

import com.example.Project.Dto.Tour_Dto;

import java.util.List;

public interface Tour_Serv_Interface {
    public List<Tour_Dto> findAll();

    public Tour_Dto findById(Long tour_id);
    public Tour_Dto findBy_TourName(String tourName);

    public Tour_Dto addTour(Tour_Dto tourDto);

    public void deleteTour(Long tour_id);

    public Tour_Dto updateTour(long tour_id, Tour_Dto tourDto);

    public Tour_Dto updateMatchesWithTour(Tour_Dto tourDto);
}
