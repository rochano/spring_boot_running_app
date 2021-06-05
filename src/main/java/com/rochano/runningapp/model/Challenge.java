package com.rochano.runningapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "challenge")
@NamedQuery(name = "Challenge.findAllByBetweenBeginDateAndEndDate", query = "select c from Challenge c where c.beginDate <= ?1 and c.endDate >= ?1")
public class Challenge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int challengeId;
	private String beginDate;
	private String endDate;
	private double targetDistance;
	private double currentDistance;

	public int getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(int challengeId) {
		this.challengeId = challengeId;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public double getTargetDistance() {
		return targetDistance;
	}

	public void setTargetDistance(double targetDistance) {
		this.targetDistance = targetDistance;
	}

	public double getCurrentDistance() {
		return currentDistance;
	}

	public void setCurrentDistance(double currentDistance) {
		this.currentDistance = currentDistance;
	}

}
