package com.nesugo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alerts", schema = "nesugo_schema")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alert_id")
	private int alertId;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "station_id")
	private int stationId;

	@ManyToOne
	@JoinColumn(name = "station_id", insertable = false, updatable = false)
	private StationEntity station;
	
//	@Column(name = "alert_time")
//	private LocalTime alertTime;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	public AlertEntity(int userId, int stationId, boolean isActive) {
		this.userId = userId;
		this.stationId = stationId;
//		this.alertTime = alertTime;
		this.isActive = isActive;
	}

}
