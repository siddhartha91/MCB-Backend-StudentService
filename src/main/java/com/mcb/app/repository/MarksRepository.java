package com.mcb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcb.app.model.Marks;


@Repository
public interface MarksRepository extends JpaRepository<Marks, Integer> {

}
