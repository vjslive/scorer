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
	
	@JsonIgnore
	private String team_pass;

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
}
