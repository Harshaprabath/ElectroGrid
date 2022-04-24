package com.paf_project.ElectroGrid.Model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private int userId;
	private String name;
	private String nic;
	private String address;
	private int phone;
	private String email;
	private String password;
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", nic=" + nic + ", address=" + address + ", phone="
				+ phone + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
	
}
