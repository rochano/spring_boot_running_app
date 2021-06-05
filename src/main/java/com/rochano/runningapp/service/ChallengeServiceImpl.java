package com.rochano.runningapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rochano.runningapp.model.Challenge;
import com.rochano.runningapp.repository.ChallengeRepository;

@Service
public class ChallengeServiceImpl implements ChallengeServiceIf {

	@Autowired
	private ChallengeRepository challengeRepository;

	@Override
	public List<Challenge> getAllChallenge() {
		return challengeRepository.findAll();
	}

	@Override
	public void addChallenge(Challenge challenge) {
		challengeRepository.save(challenge);
	}

}
