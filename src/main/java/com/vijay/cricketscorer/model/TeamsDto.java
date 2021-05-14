package com.vijay.cricketscorer.model;


public class TeamsDto {

	private Integer team_no;
	
	private String team_name;
	
	private Double team_nrr;

	private Integer match_pts;

	public Integer getTeam_no() {
		return team_no;
	}

	public void setTeam_no(Integer team_no) {
		this.team_no = team_no;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public Double getTeam_nrr() {
		return team_nrr;
	}

	public void setTeam_nrr(Double team_nrr) {
		this.team_nrr = team_nrr;
	}

	public Integer getMatch_pts() {
		return match_pts;
	}

	public void setMatch_pts(Integer match_pts) {
		this.match_pts = match_pts;
	}
}
