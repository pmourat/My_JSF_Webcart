package com.mywebcart;

import javax.faces.bean.SessionScoped;
@SessionScoped
public class Item {
	private double price;
	private String name;
    private double weightFactor;
  
	public Item(double price, String name, double weightFactor) {
        this.price = price;
        this.name = name;
        this.weightFactor = weightFactor;
      
	}



	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeightFactor() {
		return weightFactor;
	}
	public void setWeightFactor(double weightFactor) {
		this.weightFactor = weightFactor;
	}



	@Override
	public String toString() {
		return "Item [price=" + price + ", name=" + name + ", weightFactor=" + weightFactor + "]";
	}


	

	
}
