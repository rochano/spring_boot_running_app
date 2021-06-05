package com.rochano.runningapp.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rochano.runningapp.model.Challenge;
import com.rochano.runningapp.model.Track;
import com.rochano.runningapp.repository.ChallengeRepository;
import com.rochano.runningapp.repository.TrackRepository;

@Service
public class TrackServiceImpl implements TrackServiceIf {

	@Autowired
	private TrackRepository trackRepository;
	@Autowired
	private ChallengeRepository challengeRepository;

	@Override
	public List<Track> getAllTracks() {
		return trackRepository.findAll();
	}

	@Override
	public void addTrack(Track track) {
		track.getPaceList().stream().forEach(e -> {
			e.setTrack(track);
		});
		trackRepository.save(track);

		List<Challenge> challengeList = challengeRepository.findAllByBetweenBeginDateAndEndDate(track.getDate());
		challengeList.stream().forEach(challenge -> {
			double currentDistance = 0;
			List<Track> trackList = trackRepository.findAllByBetweenBeginDateAndEndDate(challenge.getBeginDate(),
					challenge.getEndDate());
			Iterator<Track> it = trackList.iterator();
			while (it.hasNext()) {
				Track track2 = it.next();
				currentDistance += track2.getDistance();
			}
			challenge.setCurrentDistance(currentDistance);
			challengeRepository.save(challenge);
		});

	}
}
