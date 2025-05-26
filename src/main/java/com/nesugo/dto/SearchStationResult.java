package com.nesugo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchStationResult {
	
	private int stationId;
    private String stationName;
    private String lineName;
    private String prefName;
    
}
