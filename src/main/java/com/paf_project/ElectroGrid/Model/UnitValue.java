package com.paf_project.ElectroGrid.Model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UnitValue {
	
	private String id;
	private int upper_limit;
	private int lower_limit;
	private double current_price_per_unit ;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getUpper_limit() {
		return upper_limit;
	}
	public void setUpper_limit(int upper_limit) {
		this.upper_limit = upper_limit;
	}
	
	public int getLower_limit() {
		return lower_limit;
	}
	public void setLower_limit(int lower_limit) {
		this.lower_limit = lower_limit;
	}
	
	public double getCurrent_price_per_unit() {
		return current_price_per_unit;
	}
	public void setCurrent_price_per_unit(double current_price_per_unit) {
		this.current_price_per_unit = current_price_per_unit;
	}
		
}
