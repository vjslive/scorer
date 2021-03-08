package com.vijay.cricketscorer.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.cricketscorer.entity.Match;
import com.vijay.cricketscorer.entity.Player;
import com.vijay.cricketscorer.entity.Team;
import com.vijay.cricketscorer.repository.MatchRepository;
import com.vijay.cricketscorer.repository.PlayerRepository;
import com.vijay.cricketscorer.repository.TeamRepository;

@Service
public class ScorerService {

	Logger log =  Logger.getLogger(ScorerService.class.getName());
	
	@Autowired
    private MatchRepository matchRepo;
	
	@Autowired
    private TeamRepository teamRepo;
	
	@Autowired
    private PlayerRepository playerRepo;

    public List<Match> findAllMatches() {

    	List<Match> matches = (List<Match>) matchRepo.findAll();
        
        matches.forEach((match) -> System.out.println(match.toString()));
        
        return matches;
    }

	public List<Team> findAllTeams() {
		List<Team> teams = (List<Team>) teamRepo.findAll();
        
		teams.forEach((team) -> System.out.println(team.toString()));
        
        return teams;
	}
	
	public List<Player> findAllPlayers() {
		List<Player> players = (List<Player>) playerRepo.findAll();
        
		players.forEach((player) -> System.out.println(player.toString()));
        
        return players;
	}

	public Optional<Team> findUserValid(String userName, String password) {
		List<Team> teams = findAllTeams();
		Optional<Team> finalTeam = teams.stream().filter(team -> team.getTeam_name().equalsIgnoreCase(userName) && team.getTeam_pass().equalsIgnoreCase(password)).findFirst();
		if (!finalTeam.isPresent()) {
			log.severe("Unauthorized access");
		}
		return finalTeam;
	}
	
}
