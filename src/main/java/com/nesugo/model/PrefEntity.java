package com.nesugo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "prefs", schema = "nesugo_schema")
@Data
public class PrefEntity {
	@Id
	@Column(name = "pref_id")
	private int prefId;
	@Column(name = "pref_name")
	private String prefName;
	
	@OneToMany(mappedBy = "pref")
	private List<StationEntity> stations;
}
