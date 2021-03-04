package com.vijay.cricketscorer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vijay.cricketscorer.entity.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long>{


}
