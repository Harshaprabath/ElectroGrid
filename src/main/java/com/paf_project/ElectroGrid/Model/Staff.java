package com.paf_project.ElectroGrid.Model;

import jakarta.xml.bind.annotation.XmlRootElement;

public class Staff {
	private int ID;
	private String CustomerName;
	private String CustomerID;
	private String StaffName;
	private int StaffID;
	private String AssignWork;
	private String Mobile;
	
	
	
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String CustomerName) {
		this.CustomerName = CustomerName;
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String CustomerID) {
		this.CustomerID = CustomerID;
	}
	public String getStaffName() {
		return StaffName;
	}
	public void setStaffName(String StaffName) {
		this.StaffName = StaffName;
	}
	public int getStaffID() {
		return StaffID;
	}
	public void setStaffID(int StaffID) {
		this.StaffID = StaffID;
	}
	public String getAssignWork() {
		return AssignWork;
	}
	public void setAssignWork(String AssignWork) {
		this.AssignWork = AssignWork;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String Mobile) {
		this.Mobile = Mobile;
	}
	@Override
	public String toString() {
		return "Staff [ID=" + ID + ", CustomerName=" +CustomerName + ", CustomerID=" + CustomerID + ", StaffName=" + StaffName + ", StaffID="
				+ StaffID + ", AssignWork=" + AssignWork + ", Mobile=" + Mobile + "]";
	}
	
	

}
