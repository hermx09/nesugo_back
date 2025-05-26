package com.nesugo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nesugo.dto.GetUserAlertsDto;
import com.nesugo.form.AlertForm;
import com.nesugo.form.ToggleForm;
import com.nesugo.service.AlertService;

@RestController
@RequestMapping("/nesugo")
public class AlertController {

	@Autowired
	private AlertService alertService;

	@GetMapping("/getUserAlerts")
	public ResponseEntity<List<GetUserAlertsDto>> getUserAlerts(int userId) {

		return ResponseEntity.status(HttpStatus.OK).body(alertService.getAlerts(userId));
	}

	@PostMapping("/insertAlert")
	public int insertAlert(@RequestBody AlertForm alertForm) {

		return alertService.doInsertAlert(alertForm.getUserId(), alertForm.getStationId(), alertForm.getAlertTime(),
				alertForm.isActive());
	}
	
	@PostMapping("/modifyAlert")
	public ResponseEntity<String> modifyAlert(@RequestBody AlertForm alertForm) {
		alertService.doModifyAlert(alertForm.getAlertId(), alertForm.getStationId(), alertForm.getAlertTime(), alertForm.isActive());
		return ResponseEntity.ok("OK");
	}
	
	@PostMapping("/deleteAlert")
	public ResponseEntity<String> deleteAlert(@RequestBody AlertForm alertForm) {
		System.out.println(alertForm);
		alertService.doDeleteAlert(alertForm.getAlertId());
		return ResponseEntity.ok("OK");
	}
	
	@PostMapping("/toggleAlert")
	public void toggleAlert(@RequestBody ToggleForm toggleForm) {
		alertService.changeAlert(toggleForm.getAlertId(), toggleForm.isActive());
	}
}
