package com.rochano.runningapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rochano.runningapp.model.PaceDetail;

@Repository
public interface PaceDetailRepository extends JpaRepository<PaceDetail, Integer> {

}
