package com.nesugo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "stations", schema = "nesugo_schema")
@Data
public class StationEntity {
	@Id
	@Column(name = "station_id")
	private int stationId;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "station_name")
	private String stationName;
	@Column(name = "lat")
	private double lat;
	@Column(name = "lon")
	private double lon;
	@ManyToOne
	@JoinColumn(name = "lineId")
	private LineEntity line;
	@ManyToOne
	@JoinColumn(name = "prefId")
	private PrefEntity pref;
}
