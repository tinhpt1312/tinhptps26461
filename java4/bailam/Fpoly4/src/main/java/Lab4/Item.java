package Lab4;

import java.util.Date;

public class Item {
	private String name;
	private String image;
	private double price;
	private double disscount;
	Date date = new Date();
	
	public Item() {
		
	}
	
	public Item(String name, String image, double price, double disscount) {
		super();
		this.name = name;
		this.image = image;
		this.price = price;
		this.disscount = disscount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDisscount() {
		return disscount;
	}
	public void setDisscount(double disscount) {
		this.disscount = disscount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
