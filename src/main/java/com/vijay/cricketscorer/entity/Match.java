package com.vijay.cricketscorer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Match", schema="scorer")
public class Match {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer match_no;
	
	private String date;
	
	private Team team_a;
	
	private Team team_b;
	
	private Team team_win;
	
	private Team umpire_team;
}
