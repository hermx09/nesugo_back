package com.nesugo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nesugo.dto.GetUserAlertsDto;
import com.nesugo.model.AlertEntity;
import com.nesugo.repository.AlertRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AlertService {

	@Autowired
	private AlertRepository alertRepository;

	public GetUserAlertsDto doInsertAlert(int userId, int stationId, boolean isActive) {

		AlertEntity alertEntity = new AlertEntity(userId, stationId, isActive);
		AlertEntity savedAlert = alertRepository.save(alertEntity);

		return alertRepository.getAlertByAlertId(savedAlert.getAlertId());
	}

	public void doModifyAlert(int alertId, int stationId, boolean isActive) {
		AlertEntity alertEntity = alertRepository.getById(alertId);
		if (alertEntity != null) {
	        alertEntity.setStationId(stationId);
	        alertEntity.setActive(isActive);
	        alertRepository.save(alertEntity);
	    } else {
	        throw new EntityNotFoundException("Alert not found with ID: " + alertId);
	    }
	}
	
	public void doDeleteAlert(int alertId) {
		alertRepository.deleteById(alertId);
	}
	
	public List<GetUserAlertsDto> getAlerts(int userId) {
		return alertRepository.getAlertsByUserId(userId);
	}
	
	public void changeAlert(String alertId, boolean active) {
		AlertEntity alert = alertRepository.getById(Integer.parseInt(alertId));
		alert.setActive(active);
		alertRepository.save(alert);
	}
}
