package com.rochano.runningapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rochano.runningapp.model.Challenge;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {
	List<Challenge> findAllByBetweenBeginDateAndEndDate(String date);
}
