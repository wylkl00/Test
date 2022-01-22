package com.chinasofti.PO;

public class Engineer {
	private int engineerId;
	private String userName;
	private String dellno;
	private String telephone;
	
	public Engineer()
	{
		this.engineerId=1;
		this.userName="zhangsan";
		this.dellno="Dell-001";
		this.telephone="010-55559999";
	}
	
	public int getEngineerId() {
		return engineerId;
	}
	public void setEngineerId(int engineerId) {
		this.engineerId = engineerId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDellno() {
		return dellno;
	}
	public void setDellno(String dellno) {
		this.dellno = dellno;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "Engineer [engineerId=" + engineerId + ", userName=" + userName + ", dellno=" + dellno + ", telephone="
				+ telephone + "]";
	}
	
}
