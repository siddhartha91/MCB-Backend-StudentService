package com.mcb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcb.app.model.Groups;


@Repository
public interface GroupsRepository extends JpaRepository<Groups, Integer> {

}
