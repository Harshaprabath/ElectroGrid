package com.paf_project.ElectroGrid.Model;


import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class PowerConsumption {
	private String id;
	private String customer_ID;
	private double value;
	private Date date;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(String customer_ID) {
		this.customer_ID = customer_ID;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	 
	 
}
