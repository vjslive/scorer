package com.vijay.cricketscorer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="player", schema="scorer")
public class Player {

	@Id
	@Column(name = "player_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer player_no;	

	private String player_name;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team", referencedColumnName = "team_no")
	private Team team;

	public Integer getPlayer_no() {
		return player_no;
	}

	public void setPlayer_no(Integer player_no) {
		this.player_no = player_no;
	}

	public String getPlayer_name() {
		return player_name;
	}

	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
