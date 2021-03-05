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

@Entity
@Table(name="team", schema="scorer")

public class Team {

	@Id
	@Column(name = "team_no")
    @GeneratedValue
	private Integer team_no;
	
	private String team_name;	

	private Integer match_pts;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="team_a",targetEntity=Match.class)
	private List<Match> matches;
	
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

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	@Override
	public String toString() {
		return "Team No::" + getTeam_no() + ", Team Name::" + getTeam_name() + ", MatchPoints::" + getMatch_pts();
	}
}
