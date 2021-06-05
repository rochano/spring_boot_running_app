package com.rochano.runningapp.service;

import java.util.List;

import com.rochano.runningapp.model.Challenge;

public interface ChallengeServiceIf {
	public List<Challenge> getAllChallenge();

	public void addChallenge(Challenge chanllenge);
}
