package com.rochano.runningapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "track")
@NamedQuery(name = "Track.findAllByBetweenBeginDateAndEndDate", query = "select t from Track t where t.date >= ?1 and t.date <= ?2")

public class Track {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trackId;
	private String image;
	private double distance;
	private double calories;
	private double pace;
	private String date;
	private String duration;
	private int avgStep;
	private int maxStep;
	private int avgHeartRt;
	private byte[] imageBytes;
	@OneToMany(mappedBy = "track", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PaceDetail> paceList;

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getPace() {
		return pace;
	}

	public void setPace(double pace) {
		this.pace = pace;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getAvgStep() {
		return avgStep;
	}

	public void setAvgStep(int avgStep) {
		this.avgStep = avgStep;
	}

	public int getMaxStep() {
		return maxStep;
	}

	public void setMaxStep(int maxStep) {
		this.maxStep = maxStep;
	}

	public int getAvgHeartRt() {
		return avgHeartRt;
	}

	public void setAvgHeartRt(int avgHeartRt) {
		this.avgHeartRt = avgHeartRt;
	}

	public List<PaceDetail> getPaceList() {
		return paceList;
	}

	public void setPaceList(List<PaceDetail> paceList) {
		this.paceList = paceList;
	}

}
