package com.nesugo.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUserAlertsDto {
	
	private int alertId;
	private int stationId;
	private String stationName;
	private double lat;
	private double lon;
	private String lineName;
	private String prefName;
	private LocalTime alertTime;
	private boolean isActive;
}
