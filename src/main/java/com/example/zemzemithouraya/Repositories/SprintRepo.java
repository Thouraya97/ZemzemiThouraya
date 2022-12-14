package com.example.zemzemithouraya.Repositories;

import com.example.zemzemithouraya.Entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SprintRepo extends JpaRepository<Sprint, Integer> {
    List<Sprint> findByStartDateIsAfter(Date date);
}
