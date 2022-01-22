package com.chinasofti.PO;

public class Product {
	private int id;
	private String pno;
	private String pname;
	private float unitprice;
	private String specifications;
	
	public Product() {
		this.id = 1;
		this.pno = "20170102-001";
		this.pname = "FootBall";
		this.unitprice = 300;
		this.specifications = "3#";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", pno=" + pno + ", pname=" + pname + ", unitprice=" + unitprice
				+ ", specifications=" + specifications + "]";
	}
	
}
