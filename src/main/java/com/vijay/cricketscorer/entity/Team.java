package com.vijay.cricketscorer.entity;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="team", schema="scorer")

public class Team {

	@Id
	@Column(name = "team_no")
    @GeneratedValue
	private Integer team_no;
	
	private String team_name;
	
	private String team_pass;

	private Integer match_pts;
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="team_a",targetEntity=Match.class)
	private List<Match> teamAmatches;
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="team_b",targetEntity=Match.class)
	private List<Match> teamBmatches;
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="team_win",targetEntity=Match.class)
	private List<Match> teamWinmatches;
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="umpire_team",targetEntity=Match.class)
	private List<Match> umpireTeammatches;
	
	@JsonManagedReference
	@JsonIgnore
	@Access(AccessType.PROPERTY)
	@OneToMany(cascade=CascadeType.ALL, mappedBy="team",targetEntity=Player.class)
	private List<Player> players;

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

	public Integer getMatch_pts() {
		return match_pts;
	}

	public void setMatch_pts(Integer match_pts) {
		this.match_pts = match_pts;
	}

	@Override
	public String toString() {
		return "Team No::" + getTeam_no() + ", Team Name::" + getTeam_name() + ", MatchPoints::" + getMatch_pts() + ", Pass::" + getTeam_pass();
	}

	public String getTeam_pass() {
		return team_pass;
	}

	public void setTeam_pass(String team_pass) {
		this.team_pass = team_pass;
	}

	public List<Match> getTeamAmatches() {
		return teamAmatches;
	}

	public void setTeamAmatches(List<Match> teamAmatches) {
		this.teamAmatches = teamAmatches;
	}

	public List<Match> getTeamBmatches() {
		return teamBmatches;
	}

	public void setTeamBmatches(List<Match> teamBmatches) {
		this.teamBmatches = teamBmatches;
	}

	public List<Match> getTeamWinmatches() {
		return teamWinmatches;
	}

	public void setTeamWinmatches(List<Match> teamWinmatches) {
		this.teamWinmatches = teamWinmatches;
	}

	public List<Match> getUmpireTeammatches() {
		return umpireTeammatches;
	}

	public void setUmpireTeammatches(List<Match> umpireTeammatches) {
		this.umpireTeammatches = umpireTeammatches;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
}
