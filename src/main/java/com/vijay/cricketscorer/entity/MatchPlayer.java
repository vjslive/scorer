package com.vijay.cricketscorer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="matchplayer", schema="scorer")
public class MatchPlayer {

	@Id
	@Column(name = "player_match_no")
    @GeneratedValue
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
	public Integer getPlayer_match_no() {
		return player_match_no;
	}
	public void setPlayer_match_no(Integer player_match_no) {
		this.player_match_no = player_match_no;
	}
	public Integer getMatch_no() {
		return match_no;
	}
	public void setMatch_no(Integer match_no) {
		this.match_no = match_no;
	}
	public Integer getPlayer_no() {
		return player_no;
	}
	public void setPlayer_no(Integer player_no) {
		this.player_no = player_no;
	}
	public Integer getRuns_taken() {
		return runs_taken;
	}
	public void setRuns_taken(Integer runs_taken) {
		this.runs_taken = runs_taken;
	}
	public Integer getBalls_faced() {
		return balls_faced;
	}
	public void setBalls_faced(Integer balls_faced) {
		this.balls_faced = balls_faced;
	}
	public Integer getRuns_given() {
		return runs_given;
	}
	public void setRuns_given(Integer runs_given) {
		this.runs_given = runs_given;
	}
	public Integer getBalls_bowled() {
		return balls_bowled;
	}
	public void setBalls_bowled(Integer balls_bowled) {
		this.balls_bowled = balls_bowled;
	}
	public Integer getFours() {
		return fours;
	}
	public void setFours(Integer fours) {
		this.fours = fours;
	}
	public Integer getSixes() {
		return sixes;
	}
	public void setSixes(Integer sixes) {
		this.sixes = sixes;
	}
	public Integer getWides() {
		return wides;
	}
	public void setWides(Integer wides) {
		this.wides = wides;
	}
	public Integer getNo_balls() {
		return no_balls;
	}
	public void setNo_balls(Integer no_balls) {
		this.no_balls = no_balls;
	}
	public Integer getByes() {
		return byes;
	}
	public void setByes(Integer byes) {
		this.byes = byes;
	}
	public Integer getWickets() {
		return wickets;
	}
	public void setWickets(Integer wickets) {
		this.wickets = wickets;
	}
	
}
