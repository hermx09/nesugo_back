package com.nesugo.form;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlertForm {

	private Integer alertId;
	
	private int userId;
	
	private int stationId;
	
	private LocalTime alertTime;
	
	private boolean isActive;
}
