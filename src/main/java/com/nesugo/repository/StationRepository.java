package com.nesugo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nesugo.dto.SearchStationResult;
import com.nesugo.model.StationEntity;

@Repository
public interface StationRepository extends JpaRepository<StationEntity, Integer>{
	
	@Query("SELECT new com.nesugo.dto.SearchStationResult(s.stationId, s.stationName, l.lineName, p.prefName) " +
			"FROM StationEntity s " +
			"LEFT OUTER JOIN s.line l " +
			"LEFT OUTER JOIN s.pref p " +
			"WHERE s.stationName LIKE :stationName")
	public List<SearchStationResult> searchStations(@Param("stationName") String stationName);
}
