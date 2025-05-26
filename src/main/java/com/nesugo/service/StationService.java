package com.nesugo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nesugo.dto.SearchStationResult;
import com.nesugo.repository.StationRepository;

@Service
public class StationService {
	
	@Autowired
	private StationRepository stationRepository;
	
	public List<SearchStationResult> getByStationName(String stationName){
		String queryStationName = '%' + stationName + '%';
		
		List<SearchStationResult> resultList = stationRepository.searchStations(queryStationName);
		if(resultList.size() == 0) {
			System.out.println("0けんです");
		}
		System.out.println(resultList);
		
		return resultList;
	}
}
