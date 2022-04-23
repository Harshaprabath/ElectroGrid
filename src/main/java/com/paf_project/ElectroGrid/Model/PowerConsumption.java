package com.paf_project.ElectroGrid.Model;




import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class PowerConsumption {
	private int id;
	private String customer_ID;
	private double value;
	private String date;

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	 
	 
}
