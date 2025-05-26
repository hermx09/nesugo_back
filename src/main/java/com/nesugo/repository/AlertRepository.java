package com.nesugo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nesugo.dto.GetUserAlertsDto;
import com.nesugo.model.AlertEntity;

public interface AlertRepository extends JpaRepository<AlertEntity, Integer> {

	@Query("SELECT new com.nesugo.dto.GetUserAlertsDto(a.alertId, s.stationId, s.stationName, s.lat, s.lon, l.lineName, p.prefName, a.alertTime, a.isActive) FROM AlertEntity a "
			+ "JOIN a.station s " + "JOIN s.line l " + "JOIN s.pref p "
			+ "WHERE a.userId = :userId")
	public List<GetUserAlertsDto> getAlertsByUserId(@Param("userId") int userId);
}
