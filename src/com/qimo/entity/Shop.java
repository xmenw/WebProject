package com.qimo.entity;

import java.io.Serializable;

public class Shop implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String username;
	private String pic;
	private String desc;
	private String color;
	private String size;
	private double price;
	private int num;
	
	public Shop() {
		
	}
	
	public Shop(int id, String username, String pic, String desc, String color, String size, double price, int num) {
		super();
		this.id = id;
		this.username = username;
		this.pic = pic;
		this.desc = desc;
		this.color = color;
		this.size = size;
		this.price = price;
		this.num = num;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", username=" + username + ", pic=" + pic + ", desc=" + desc + ", color=" + color
				+ ", size=" + size + ", price=" + price + ", num=" + num + "]";
	}
	
	
	
}
