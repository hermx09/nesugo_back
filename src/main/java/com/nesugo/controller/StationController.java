package com.nesugo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nesugo.dto.SearchStationResult;
import com.nesugo.service.StationService;

@RestController
@RequestMapping("/nesugo")
public class StationController {

	@Autowired
	private StationService stationService;

	@GetMapping("/getStations")
	public List<SearchStationResult> getStations(@RequestParam String name) {

		return stationService.getByStationName(name);
	}
}
