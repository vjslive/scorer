package com.vijay.cricketscorer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="matchplayer", schema="scorer")
public class MatchPlayer {

	@Id
	@Column(name = "player_match_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer player_match_no;	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "match_no", referencedColumnName = "match_no")
	private Match matchNo;	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_no", referencedColumnName = "player_no")
	private Player playerNo;	
	private Integer runs_taken;	
	private Integer balls_faced;	
	
	private Integer balls_bowled;	
	private Integer fours;	
	private Integer sixes;	
	private Integer wides;	
	private Integer no_balls;	
	private Integer byes;	
	private Integer wickets;
	private Integer battingorder;
	private String out;
	private Integer gaveruns;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bowler", referencedColumnName = "player_no")
	private Player bowler;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fielder", referencedColumnName = "player_no")
	private Player fielder;
	public Integer getPlayer_match_no() {
		return player_match_no;
	}
	public void setPlayer_match_no(Integer player_match_no) {
		this.player_match_no = player_match_no;
	}
	public Integer getRuns_taken() {
		return runs_taken;
	}
	public void setRuns_taken(Integer runs_taken) {
		this.runs_taken = runs_taken;
	}
	public Integer getBalls_faced() {
		return balls_faced;
	}
	public void setBalls_faced(Integer balls_faced) {
		this.balls_faced = balls_faced;
	}
	public Integer getGaveruns() {
		return gaveruns;
	}
	public void setGaveruns(Integer gaveruns) {
		this.gaveruns = gaveruns;
	}
	public Integer getBalls_bowled() {
		return balls_bowled;
	}
	public void setBalls_bowled(Integer balls_bowled) {
		this.balls_bowled = balls_bowled;
	}
	public Integer getFours() {
		return fours;
	}
	public void setFours(Integer fours) {
		this.fours = fours;
	}
	public Integer getSixes() {
		return sixes;
	}
	public void setSixes(Integer sixes) {
		this.sixes = sixes;
	}
	public Integer getWides() {
		return wides;
	}
	public void setWides(Integer wides) {
		this.wides = wides;
	}
	public Integer getNo_balls() {
		return no_balls;
	}
	public void setNo_balls(Integer no_balls) {
		this.no_balls = no_balls;
	}
	public Integer getByes() {
		return byes;
	}
	public void setByes(Integer byes) {
		this.byes = byes;
	}
	public Integer getWickets() {
		return wickets;
	}
	public void setWickets(Integer wickets) {
		this.wickets = wickets;
	}
	public Match getMatchNo() {
		return matchNo;
	}
	public void setMatchNo(Match match_no) {
		this.matchNo = match_no;
	}
	public Player getPlayerNo() {
		return playerNo;
	}
	public Integer getBattingorder() {
		return battingorder;
	}
	public void setBattingorder(Integer battingorder) {
		this.battingorder = battingorder;
	}
	public void setPlayerNo(Player playerNo) {
		this.playerNo = playerNo;
	}
	public String getOut() {
		return out;
	}
	public void setOut(String out) {
		this.out = out;
	}
	public Player getBowler() {
		return bowler;
	}
	public void setBowler(Player bowler) {
		this.bowler = bowler;
	}
	public Player getFielder() {
		return fielder;
	}
	public void setFielder(Player fielder) {
		this.fielder = fielder;
	}
	
}
