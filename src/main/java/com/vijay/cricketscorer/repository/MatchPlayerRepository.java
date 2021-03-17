package com.vijay.cricketscorer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vijay.cricketscorer.entity.Match;
import com.vijay.cricketscorer.entity.MatchPlayer;
import com.vijay.cricketscorer.entity.Player;

@Repository
public interface MatchPlayerRepository extends CrudRepository<MatchPlayer, Integer> {
	List<MatchPlayer> findByMatchNo(Match matchNo);
	List<MatchPlayer> findByPlayerNo(Player playerNo);
}
