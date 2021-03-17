package com.vijay.cricketscorer.model;

public class BowlerDto {

	private Integer bowlerNo;
	private String bowlerName;
	private String overs;
	private Integer runsgiven;
	private Integer runsgive;
	private Integer byes;
	private Integer wides;
	private Integer noBalls;
	private Integer wickets;
	
	public Integer getBowlerNo() {
		return bowlerNo;
	}
	public void setBowlerNo(Integer bowlerNo) {
		this.bowlerNo = bowlerNo;
	}
	public String getBowlerName() {
		return bowlerName;
	}
	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}
	public String getOvers() {
		return overs;
	}
	public void setOvers(String overs) {
		this.overs = overs;
	}
	public Integer getRunsgiven() {
		return runsgiven;
	}
	public void setRunsgiven(Integer runs) {
		this.runsgiven = runsgiven;
	}
	public Integer getByes() {
		return byes;
	}
	public void setByes(Integer byes) {
		this.byes = byes;
	}
	public Integer getWides() {
		return wides;
	}
	public void setWides(Integer wides) {
		this.wides = wides;
	}
	public Integer getNoBalls() {
		return noBalls;
	}
	public void setNoBalls(Integer noBalls) {
		this.noBalls = noBalls;
	}
	public Integer getWickets() {
		return wickets;
	}
	public void setWickets(Integer wickets) {
		this.wickets = wickets;
	}
	public Integer getRunsgive() {
		return runsgive;
	}
	public void setRunsgive(Integer runsgive) {
		this.runsgive = runsgive;
	}
}
