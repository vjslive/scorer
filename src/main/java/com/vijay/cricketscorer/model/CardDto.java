package com.vijay.cricketscorer.model;

import java.util.ArrayList;
import java.util.List;

public class CardDto {

	private List<BowlerDto> bowlers = new ArrayList<BowlerDto>(); 
	private List<BatsmanDto> batsmen = new ArrayList<BatsmanDto>();
	private Integer total;
	private Integer matchNo;
	private String firstInnings;
	private String matchWonBy;
	
	public Integer getMatchNo() {
		return matchNo;
	}
	public void setMatchNo(Integer matchNo) {
		this.matchNo = matchNo;
	}
	public List<BowlerDto> getBowlers() {
		return bowlers;
	}
	public void setBowlers(List<BowlerDto> bowlers) {
		this.bowlers = bowlers;
	}
	public List<BatsmanDto> getBatsmen() {
		return batsmen;
	}
	public void setBatsmen(List<BatsmanDto> batsmen) {
		this.batsmen = batsmen;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getFirstInnings() {
		return firstInnings;
	}
	public void setFirstInnings(String firstInnings) {
		this.firstInnings = firstInnings;
	}
	public String getMatchWonBy() {
		return matchWonBy;
	}
	public void setMatchWonBy(String matchWonBy) {
		this.matchWonBy = matchWonBy;
	}
}
