package com.vijay.cricketscorer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vijay.cricketscorer.entity.Player;
import com.vijay.cricketscorer.entity.Team;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer>{
	List<Player> findByTeam(Team team);

}
