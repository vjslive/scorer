package com.vijay.cricketscorer.model;

public class BestAllRounderDto {
	String playerName;
	Integer score;
	Integer innings;
	Integer wickets;
	Integer balls;
	Integer points;
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
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getInnings() {
		return innings;
	}
	public void setInnings(Integer innings) {
		this.innings = innings;
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
}
