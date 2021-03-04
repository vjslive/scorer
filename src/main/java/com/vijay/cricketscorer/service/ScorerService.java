package com.vijay.cricketscorer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vijay.cricketscorer.entity.Match;
import com.vijay.cricketscorer.repository.MatchRepository;

public class ScorerService {

	@Autowired
    private MatchRepository repository;

    public List<Match> findAll() {

        var matches = (List<Match>) repository.findAll();

        return matches;
    }
	
}
