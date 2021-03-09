package com.vijay.cricketscorer.model;

public class PlayerDto {

	private String playerName;
	private Integer teamNo;
	private String result;
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Integer getTeamNo() {
		return teamNo;
	}
	public void setTeamNo(Integer teamNo) {
		this.teamNo = teamNo;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
