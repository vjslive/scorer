package com.vijay.cricketscorer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vijay.cricketscorer.entity.MatchPlayer;

@Repository
public interface MatchPlayerRepository extends CrudRepository<MatchPlayer, Long> {

}
