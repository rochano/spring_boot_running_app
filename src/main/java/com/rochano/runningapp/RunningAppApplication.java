package com.rochano.runningapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rochano.runningapp.model.Challenge;
import com.rochano.runningapp.model.PaceDetail;
import com.rochano.runningapp.model.Track;
import com.rochano.runningapp.repository.ChallengeRepository;
import com.rochano.runningapp.repository.PaceDetailRepository;
import com.rochano.runningapp.repository.TrackRepository;

@SpringBootApplication
public class RunningAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunningAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(TrackRepository trackRepository, PaceDetailRepository paceDetailRepository,
			ChallengeRepository challengeRepository) {
		return args -> {
			// track #1
			Track track1 = new Track();
			track1.setTrackId(1);
			track1.setImage("");
			track1.setDistance(10.01);
			track1.setCalories(503);
			track1.setPace(8);
			track1.setDate("20200120");
			track1.setDuration("005033");
			track1.setAvgStep(275);
			track1.setMaxStep(560);
			track1.setAvgHeartRt(120);
			trackRepository.save(track1);

			// pace detail #1
			PaceDetail paceDetail = new PaceDetail();
			paceDetail.setPaceId(1);
			paceDetail.setDistance(0.1);
			paceDetail.setPace(9.25);
			paceDetail.setTrack(track1);
			paceDetailRepository.save(paceDetail);

			// pace detail #2
			paceDetail = new PaceDetail();
			paceDetail.setPaceId(2);
			paceDetail.setDistance(0.2);
			paceDetail.setPace(9.23);
			paceDetail.setTrack(track1);
			paceDetailRepository.save(paceDetail);

			// pace detail #3
			paceDetail = new PaceDetail();
			paceDetail.setPaceId(3);
			paceDetail.setDistance(0.4);
			paceDetail.setPace(9.20);
			paceDetail.setTrack(track1);
			paceDetailRepository.save(paceDetail);

			// pace detail #4
			paceDetail = new PaceDetail();
			paceDetail.setPaceId(4);
			paceDetail.setDistance(0.5);
			paceDetail.setPace(9.19);
			paceDetail.setTrack(track1);
			paceDetailRepository.save(paceDetail);

			// pace detail #5
			paceDetail = new PaceDetail();
			paceDetail.setPaceId(5);
			paceDetail.setDistance(0.3);
			paceDetail.setPace(9.21);
			paceDetail.setTrack(track1);
			paceDetailRepository.save(paceDetail);

			// pace detail #6
			paceDetail = new PaceDetail();
			paceDetail.setPaceId(6);
			paceDetail.setDistance(0.6);
			paceDetail.setPace(9.17);
			paceDetail.setTrack(track1);
			paceDetailRepository.save(paceDetail);

			// pace detail #7
			paceDetail = new PaceDetail();
			paceDetail.setPaceId(7);
			paceDetail.setDistance(0.7);
			paceDetail.setPace(9.15);
			paceDetail.setTrack(track1);
			paceDetailRepository.save(paceDetail);

			// pace detail #8
			paceDetail = new PaceDetail();
			paceDetail.setPaceId(8);
			paceDetail.setDistance(0.8);
			paceDetail.setPace(9.12);
			paceDetail.setTrack(track1);
			paceDetailRepository.save(paceDetail);

			// pace detail #9
			paceDetail = new PaceDetail();
			paceDetail.setPaceId(9);
			paceDetail.setDistance(0.9);
			paceDetail.setPace(9.10);
			paceDetail.setTrack(track1);
			paceDetailRepository.save(paceDetail);

			// track #2
			Track track2 = new Track();
			track2.setTrackId(2);
			track2.setImage("");
			track2.setDistance(40.53);
			track2.setCalories(359);
			track2.setPace(8);
			track2.setDate("20200125");
			track2.setDuration("004526");
			track2.setAvgStep(275);
			track2.setMaxStep(560);
			track2.setAvgHeartRt(111);
			trackRepository.save(track2);

			// pace detail #10
			paceDetail = new PaceDetail();
			paceDetail.setPaceId(10);
			paceDetail.setDistance(2.0);
			paceDetail.setPace(7.30);
			paceDetail.setTrack(track2);
			paceDetailRepository.save(paceDetail);

			// track #3
			Track track3 = new Track();
			track3.setTrackId(3);
			track3.setImage("");
			track3.setDistance(35.67);
			track3.setCalories(266);
			track3.setPace(9);
			track3.setDate("20200203");
			track3.setDuration("003533");
			track3.setAvgStep(275);
			track3.setMaxStep(560);
			track3.setAvgHeartRt(115);
			trackRepository.save(track3);

			// pace detail #11
			paceDetail = new PaceDetail();
			paceDetail.setPaceId(11);
			paceDetail.setDistance(3.0);
			paceDetail.setPace(7.18);
			paceDetail.setTrack(track3);
			paceDetailRepository.save(paceDetail);

			// track #4
			Track track4 = new Track();
			track4.setTrackId(4);
			track4.setImage("");
			track4.setDistance(34.67);
			track4.setCalories(266);
			track4.setPace(9);
			track4.setDate("20200304");
			track4.setDuration("003533");
			track4.setAvgStep(275);
			track4.setMaxStep(560);
			track4.setAvgHeartRt(98);
			trackRepository.save(track4);

			// pace detail #12
			paceDetail = new PaceDetail();
			paceDetail.setPaceId(12);
			paceDetail.setDistance(4.0);
			paceDetail.setPace(8.25);
			paceDetail.setTrack(track4);
			paceDetailRepository.save(paceDetail);

			// pace detail #13
			paceDetail = new PaceDetail();
			paceDetail.setPaceId(13);
			paceDetail.setDistance(4.5);
			paceDetail.setPace(8.11);
			paceDetail.setTrack(track4);
			paceDetailRepository.save(paceDetail);

			// track #5
			Track track5 = new Track();
			track5.setTrackId(5);
			track5.setImage("");
			track5.setDistance(35.67);
			track5.setCalories(266);
			track5.setPace(6);
			track5.setDate("20200405");
			track5.setDuration("003533");
			track5.setAvgStep(275);
			track5.setMaxStep(560);
			track5.setAvgHeartRt(105);
			trackRepository.save(track5);

			// track #6
			Track track6 = new Track();
			track6.setTrackId(6);
			track6.setImage("");
			track6.setDistance(36.67);
			track6.setCalories(266);
			track6.setPace(7);
			track6.setDate("20200506");
			track6.setDuration("003533");
			track6.setAvgStep(275);
			track6.setMaxStep(560);
			track6.setAvgHeartRt(99);
			trackRepository.save(track6);

			// track #7
			Track track7 = new Track();
			track7.setTrackId(7);
			track7.setImage("");
			track7.setDistance(37.67);
			track7.setCalories(266);
			track7.setPace(10);
			track7.setDate("20200607");
			track7.setDuration("003533");
			track7.setAvgStep(275);
			track7.setMaxStep(560);
			track7.setAvgHeartRt(101);
			trackRepository.save(track7);

			// track #8
			Track track8 = new Track();
			track8.setTrackId(8);
			track8.setImage("");
			track8.setDistance(38.67);
			track8.setCalories(266);
			track8.setPace(4);
			track8.setDate("20200708");
			track8.setDuration("003533");
			track8.setAvgStep(275);
			track8.setMaxStep(560);
			track8.setAvgHeartRt(110);
			trackRepository.save(track8);

			// track #9
			Track track9 = new Track();
			track9.setTrackId(9);
			track9.setImage("");
			track9.setDistance(39.67);
			track9.setCalories(266);
			track9.setPace(5);
			track9.setDate("20200809");
			track9.setDuration("003533");
			track9.setAvgStep(275);
			track9.setMaxStep(560);
			track9.setAvgHeartRt(115);
			trackRepository.save(track9);

			// track #10
			Track track10 = new Track();
			track10.setTrackId(10);
			track10.setImage("");
			track10.setDistance(40.67);
			track10.setCalories(266);
			track10.setPace(9);
			track10.setDate("20200910");
			track10.setDuration("003533");
			track10.setAvgStep(275);
			track10.setMaxStep(560);
			track10.setAvgHeartRt(97);
			trackRepository.save(track10);

			// track #11
			Track track11 = new Track();
			track11.setTrackId(11);
			track11.setImage("");
			track11.setDistance(41.67);
			track11.setCalories(266);
			track11.setPace(13);
			track11.setDate("20201011");
			track11.setDuration("003533");
			track11.setAvgStep(275);
			track11.setMaxStep(560);
			track11.setAvgHeartRt(115);
			trackRepository.save(track11);

			// track #12
			Track track12 = new Track();
			track12.setTrackId(12);
			track12.setImage("");
			track12.setDistance(42.67);
			track12.setCalories(266);
			track12.setPace(7);
			track12.setDate("20201112");
			track12.setDuration("003533");
			track12.setAvgStep(275);
			track12.setMaxStep(560);
			track12.setAvgHeartRt(120);
			trackRepository.save(track12);

			// challenge #1
			Challenge challenge1 = new Challenge();
			challenge1.setChallengeId(1);
			challenge1.setBeginDate("20200101");
			challenge1.setEndDate("20200130");
			challenge1.setTargetDistance(30.00);
			challenge1.setCurrentDistance(30.00);
			challengeRepository.save(challenge1);

			// challenge #2
			Challenge challenge2 = new Challenge();
			challenge2.setChallengeId(2);
			challenge2.setBeginDate("20200301");
			challenge2.setEndDate("20200331");
			challenge2.setTargetDistance(40.00);
			challenge2.setCurrentDistance(35.00);
			challengeRepository.save(challenge2);

			// challenge #3
			Challenge challenge3 = new Challenge();
			challenge3.setChallengeId(3);
			challenge3.setBeginDate("20210101");
			challenge3.setEndDate("20210131");
			challenge3.setTargetDistance(50.00);
			challenge3.setCurrentDistance(0.00);
			challengeRepository.save(challenge3);
		};
	}
}
