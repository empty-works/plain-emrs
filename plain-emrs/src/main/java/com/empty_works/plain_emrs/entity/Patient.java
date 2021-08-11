package com.empty_works.plain_emrs.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="patients")
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient_id")
}
