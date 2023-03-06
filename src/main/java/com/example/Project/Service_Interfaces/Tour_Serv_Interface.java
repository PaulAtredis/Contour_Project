package com.example.Project.Service_Interfaces;

import com.example.Project.Dto.Tour_Dto;

import java.util.List;

public interface Tour_Serv_Interface {
    public List<Tour_Dto> findAll();

    public List<Tour_Dto> findById(Long tour_id);

//    public List<Tour_Dto> findByYear(Long tour_year);

    public Tour_Dto addTour(Tour_Dto tourDto);

    public void deleteTour(Long tour_id);

    public Tour_Dto updateTour(long tour_id, Tour_Dto tourDto);
}
