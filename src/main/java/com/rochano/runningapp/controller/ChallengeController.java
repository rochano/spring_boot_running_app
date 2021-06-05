package com.rochano.runningapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rochano.runningapp.model.Challenge;
import com.rochano.runningapp.service.ChallengeServiceIf;

@RestController
@CrossOrigin(origins = "*")
public class ChallengeController {

	@Autowired
	private ChallengeServiceIf challengeService;

	@RequestMapping(value = "getallchallenges", method = RequestMethod.GET)
	public List<Challenge> getAllChanllenge() {
		return challengeService.getAllChallenge();
	}

	@RequestMapping(value = "addchallenge", method = RequestMethod.POST)
	public void addChallenge(@RequestBody Challenge challenge) {
		challengeService.addChallenge(challenge);
	}
}
