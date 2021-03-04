package com.vijay.cricketscorer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vijay.cricketscorer.entity.Match;
import com.vijay.cricketscorer.service.ScorerService;

@Controller
public class ScorerController {
	 @Autowired
	    private ScorerService scorerService;

	    @GetMapping("/showMatches")
	    public String findMatches(Model model) {

	        var cities = (List<Match>) scorerService.findAll();

	        model.addAttribute("cities", cities);

	        return "showMatches";
	    }
}
