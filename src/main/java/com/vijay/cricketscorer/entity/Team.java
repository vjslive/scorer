package com.vijay.cricketscorer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Team", schema="scorer")

public class Team {

	@Id
	private Integer team_no;
	
	private String team_name;	

	private Integer match_pts;
}
