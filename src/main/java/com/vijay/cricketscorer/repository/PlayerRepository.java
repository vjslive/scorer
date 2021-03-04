package com.vijay.cricketscorer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vijay.cricketscorer.entity.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long>{


}
