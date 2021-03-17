package com.vijay.cricketscorer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vijay.cricketscorer.entity.Match;

@Repository
public interface MatchRepository extends CrudRepository<Match, Integer>{


}
