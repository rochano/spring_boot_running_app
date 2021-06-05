package com.rochano.runningapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pace_detail")
public class PaceDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paceId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "track_id", nullable = false)
	@JsonIgnore
	private Track track;
	private double distance;
	private double pace;

	public int getPaceId() {
		return paceId;
	}

	public void setPaceId(int paceId) {
		this.paceId = paceId;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getPace() {
		return pace;
	}

	public void setPace(double pace) {
		this.pace = pace;
	}
}
