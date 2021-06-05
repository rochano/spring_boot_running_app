package com.rochano.runningapp.service;

import java.util.List;

import com.rochano.runningapp.model.Track;

public interface TrackServiceIf {
	public List<Track> getAllTracks();

	public void addTrack(Track track);
}
