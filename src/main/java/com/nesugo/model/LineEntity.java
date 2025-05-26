package com.nesugo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "lines", schema = "nesugo_schema")
@Data
public class LineEntity {
	@Id
	@Column(name = "line_id")
	private int lineId;
	@Column(name = "line_name")
	private String lineName;

	@OneToMany(mappedBy = "line")
	private List<StationEntity> stations;
}
