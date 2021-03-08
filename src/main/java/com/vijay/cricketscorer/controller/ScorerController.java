package com.vijay.cricketscorer.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.cricketscorer.entity.Match;
import com.vijay.cricketscorer.entity.Team;
import com.vijay.cricketscorer.model.User;
import com.vijay.cricketscorer.service.ScorerService;


@RestController

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
	public String findMatches(Model model) {

		List<Match> matches =  scorerService.findAllMatches();

		model.addAttribute("matches", matches);

		return "showMatches";
	}

	@PostMapping("/team/signin")
	public ResponseEntity<?> getUser(@RequestBody User user) {
		log.info("Inside getUser");
		Optional<Team> team = scorerService.findUserValid(user.getUserName(), user.getPassword());
		
		if (team.isPresent()) {
			return new ResponseEntity<>(team.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
		}
	}
}
