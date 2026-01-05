package com.mindcraft.requestDTO;



public class EmployeeRequest {

	EmployeeRequest()
	{
		
	}
    
	public EmployeeRequest(String empId, String empName, String adhar, String email, String phone, String gender,
			String address, String state, String country) {
	
		this.empId = empId;
		this.empName = empName;
		this.adhar = adhar;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
		this.state = state;
		this.country = country;
	}

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	private String empId;
    private String empName;
    private String adhar;
    private String email;
    private String phone;
    private String gender;
    private String address;
    private String state;
    private String country;
}
