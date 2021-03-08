package com.vijay.cricketscorer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="match", schema="scorer")
public class Match {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer match_no;
	
	private String date;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_a", referencedColumnName = "team_no")
	private Team team_a;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_b", referencedColumnName = "team_no")
	private Team team_b;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_win", referencedColumnName = "team_no")
	private Team team_win;
	
	private String time;
	
	private String venue;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "umpire_team", referencedColumnName = "team_no")
	private Team umpire_team;

	public Integer getMatch_no() {
		return match_no;
	}

	public void setMatch_no(Integer match_no) {
		this.match_no = match_no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Team getTeam_a() {
		return team_a;
	}

	public void setTeam_a(Team team_a) {
		this.team_a = team_a;
	}

	public Team getTeam_b() {
		return team_b;
	}

	public void setTeam_b(Team team_b) {
		this.team_b = team_b;
	}

	public Team getTeam_win() {
		return team_win;
	}

	public void setTeam_win(Team team_win) {
		this.team_win = team_win;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Team getUmpire_team() {
		return umpire_team;
	}

	public void setUmpire_team(Team umpire_team) {
		this.umpire_team = umpire_team;
	}
	
	@Override
	public String toString() {
		return "Match No::" + getMatch_no() + ", Date::" +  getDate() + ", TeamA::" + getTeam_a().toString() + ", TeamB::"
				+ getTeam_b().toString() + ", TeamWin::" + getTeam_win() + ", Time::" +  getTime() + ", Venue::" + getVenue() 
				+ ", UmpireTeam::" + getUmpire_team();
	}
}
