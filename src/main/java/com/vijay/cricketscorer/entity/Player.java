package com.vijay.cricketscorer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Player", schema="scorer")
public class Player {

	@Id
	private Integer player_no;	

	private String player_name;
	
	private Team team;
}
