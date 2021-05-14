package com.vijay.cricketscorer.model;

import java.util.ArrayList;
import java.util.List;

public class AwardsDto {
	private List<BestAllRounderDto> bestAllrounderList = new ArrayList<BestAllRounderDto>();
	private List<BestBatsmanDto> bestBatsmanList = new ArrayList<BestBatsmanDto>();
	private List<BestBowlerDto> bestBowlerList = new ArrayList<BestBowlerDto>();
	public List<BestAllRounderDto> getBestAllrounderList() {
		return bestAllrounderList;
	}
	public void setBestAllrounderList(List<BestAllRounderDto> bestAllrounderList) {
		this.bestAllrounderList = bestAllrounderList;
	}
	public List<BestBatsmanDto> getBestBatsmanList() {
		return bestBatsmanList;
	}
	public void setBestBatsmanList(List<BestBatsmanDto> bestBatsmanList) {
		this.bestBatsmanList = bestBatsmanList;
	}
	public List<BestBowlerDto> getBestBowlerList() {
		return bestBowlerList;
	}
	public void setBestBowlerList(List<BestBowlerDto> bestBowlerList) {
		this.bestBowlerList = bestBowlerList;
	}
}
