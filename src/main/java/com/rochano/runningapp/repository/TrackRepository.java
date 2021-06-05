package com.rochano.runningapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rochano.runningapp.model.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
	List<Track> findAllByBetweenBeginDateAndEndDate(String beginDate, String endDate);
}
