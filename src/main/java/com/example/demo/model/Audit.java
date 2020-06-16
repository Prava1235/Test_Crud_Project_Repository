package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Audit")
@Entity
public class Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "typeofaction")
	private String typeOfAction;
	@Column(name = "starttimeofaction")
	private Timestamp startTimeOfAction;
	@Column(name = "endtimeofaction")
	private Timestamp endTimeOfAction;
	public String getTypeOfAction() {
		return typeOfAction;
	}
	public void setTypeOfAction(String typeOfAction) {
		this.typeOfAction = typeOfAction;
	}
	public Timestamp getStartTimeOfAction() {
		return startTimeOfAction;
	}
	public void setStartTimeOfAction(Timestamp startTimeOfAction) {
		this.startTimeOfAction = startTimeOfAction;
	}
	public Timestamp getEndTimeOfAction() {
		return endTimeOfAction;
	}
	public void setEndTimeOfAction(Timestamp endTimeOfAction) {
		this.endTimeOfAction = endTimeOfAction;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Audit(int id,String typeOfAction, Timestamp startTimeOfAction, Timestamp endTimeOfAction) {
		super();
		this.id=id;
		this.typeOfAction = typeOfAction;
		this.startTimeOfAction = startTimeOfAction;
		this.endTimeOfAction = endTimeOfAction;
	}
	
	public Audit() {
		
	}

}