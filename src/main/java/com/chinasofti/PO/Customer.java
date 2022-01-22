package com.chinasofti.PO;

public class Customer {
	private int customerId;
	private String user_name;
	private String regin;
	private String postcode;
	private String contactor;
	private String telephone;
	private String fax;
	
	public Customer()
	{
		this.customerId=1;
		this.user_name="tom";
		this.regin="BJ";
		this.postcode="100010";
		this.contactor="tom";
		this.telephone="13100000000";
		this.fax="010-55559999";
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getRegin() {
		return regin;
	}
	public void setRegin(String regin) {
		this.regin = regin;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getContactor() {
		return contactor;
	}
	public void setContactor(String contactor) {
		this.contactor = contactor;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", user_name=" + user_name + ", regin=" + regin + ", postcode="
				+ postcode + ", contactor=" + contactor + ", telephone=" + telephone + ", fax=" + fax + "]";
	}
	
}
