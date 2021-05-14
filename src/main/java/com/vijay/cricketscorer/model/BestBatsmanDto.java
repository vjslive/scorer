package com.vijay.cricketscorer.model;

public class BestBatsmanDto {
	String playerName;
	Integer score;
	Integer innings;
	Integer points;
	String team;
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
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
}
