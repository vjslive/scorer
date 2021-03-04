package com.vijay.cricketscorer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MatchPlayer", schema="scorer")
public class MatchPlayer {

	@Id
	private Integer player_match_no;	
	private Integer match_no;	
	private Integer player_no;	
	private Integer runs_taken;	
	private Integer balls_faced;	
	private Integer runs_given;
	private Integer balls_bowled;	
	private Integer fours;	
	private Integer sixes;	
	private Integer wides;	
	private Integer no_balls;	
	private Integer byes;	
	private Integer wickets;
	
}
