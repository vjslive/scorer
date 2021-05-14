package com.vijay.cricketscorer.model;

public class BestBowlerDto {
	String playerName;
	Integer wickets;
	Integer balls;
	Integer points;
	Integer givenruns;
	String team;
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Integer getWickets() {
		return wickets;
	}
	public void setWickets(Integer wickets) {
		this.wickets = wickets;
	}
	public Integer getBalls() {
		return balls;
	}
	public void setBalls(Integer balls) {
		this.balls = balls;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Integer getGivenruns() {
		return givenruns;
	}
	public void setGivenruns(Integer givenruns) {
		this.givenruns = givenruns;
	}
	
}
