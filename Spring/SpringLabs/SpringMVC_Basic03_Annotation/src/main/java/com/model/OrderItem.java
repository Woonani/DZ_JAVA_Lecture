package com.model;

//DB 상품 테이블 가정
//1:1매핑

public class OrderItem {
	private int itemid;
	private int number;
	private String remark;
	
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "OrderItem [itemid=" + itemid + ", number=" + number + ", remark=" + remark + "]";
	}
	
	
}

