package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leavetypes")
public class Leaves {
	@Id
	@Column(name="name")
	private String name;

	public Leaves() {
		super();
	}

	public Leaves(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
