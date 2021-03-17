package com.vijay.cricketscorer.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.cricketscorer.entity.Match;
import com.vijay.cricketscorer.entity.Player;
import com.vijay.cricketscorer.entity.Team;
import com.vijay.cricketscorer.model.CardDto;
import com.vijay.cricketscorer.model.PlayerDto;
import com.vijay.cricketscorer.model.ScorecardDto;
import com.vijay.cricketscorer.model.UserDto;
import com.vijay.cricketscorer.service.ScorerService;


@RestController
@CrossOrigin(value = "*")
public class ScorerController {
	
	Logger log = Logger.getLogger(ScorerController.class.getName());
	@Autowired	
	private ScorerService scorerService;
	
	@GetMapping("/")
	public String apiConnect() {

		
		log.info("Inside apiConnect");
		return "showMatches";
	}

	@GetMapping("/showMatches")
	public ResponseEntity<?> findMatches() {

		List<Match> matches =  scorerService.findAllMatches();

		return new ResponseEntity<>(matches, HttpStatus.OK);

	}

	@PostMapping("/team/signin")
	public ResponseEntity<?> getUser(@RequestBody UserDto user) {
		log.info("Inside getUser");
		Optional<Team> team = scorerService.findUserValid(user.getUserName(), user.getPassword());
		
		if (team.isPresent()) {
			return new ResponseEntity<>(team.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("/addPlayer")
	public ResponseEntity<?> addPlayer(@RequestBody PlayerDto player) {
		log.info("Inside addPlayer");
		List<Player> players = scorerService.addPlayer(player.getPlayerName(), player.getTeamNo());
		
		if (players.isEmpty()) {
			return new ResponseEntity<>("Adding player failed", HttpStatus.SERVICE_UNAVAILABLE);
		} else {
			return new ResponseEntity<>(players, HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/getPlayers/{team_no}")
	public ResponseEntity<?> getPlayers(@PathVariable String team_no) {
		log.info("Inside getPlayers");
		List<Player> players = scorerService.getPlayers(Integer.valueOf(team_no)); 
		
			return new ResponseEntity<>(players, HttpStatus.OK);
	}
	
	@GetMapping("/getTeams")
	public ResponseEntity<?> getTeams() {
		log.info("Inside getTeams");
		List<Team> teams = scorerService.findAllTeams(); 
		
		if (teams.isEmpty()) {
			return new ResponseEntity<>("Getting teams failed", HttpStatus.SERVICE_UNAVAILABLE);
		} else {
			return new ResponseEntity<>(teams, HttpStatus.OK);
		}
	}
	
	@GetMapping("/getScorecard/{match}")
	public ResponseEntity<?> getScorecardbyMatch(@PathVariable String match) {
		log.info("Inside getScorecardbyMatch");
		ScorecardDto scorecard = scorerService.getScorecardByMatch(Integer.valueOf(match)); 
		
			return new ResponseEntity<>(scorecard, HttpStatus.OK);
	}
	
	@PostMapping("/saveScorecard")
	public ResponseEntity<?> saveScorecard(@RequestBody CardDto cardDto) {
		log.info("Inside getScorecardbyMatch");
		String message =  scorerService.saveScorecard(cardDto); 
			
			return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
