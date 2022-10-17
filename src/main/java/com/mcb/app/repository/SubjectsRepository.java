package com.mcb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcb.app.model.Subjects;


@Repository
public interface SubjectsRepository extends JpaRepository<Subjects , Integer> {

}
