package com.example.zemzemithouraya.Repositories;

import com.example.zemzemithouraya.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
    List<Project> findAllBySprintsIsAfter(Date date);


}
