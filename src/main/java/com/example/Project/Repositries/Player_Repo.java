package com.example.Project.Repositries;

import com.example.Project.Entities.Player_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Player_Repo extends JpaRepository<Player_Entity, Integer> {

}

