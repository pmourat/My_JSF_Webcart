package com.mywebcart;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@SessionScoped
@ManagedBean(name = "itemsBean")
public class ItemsBean {
	Item productOne = new Item(90.3,"productOne",0.4);
	Item productTwo = new Item(20.5,"productTwo",0.2);
	Item productThree = new Item(40.3,"productThree",0.1);
	Item productFour = new Item(55.1,"productFour",0.5);
	
	public Item getProductOne() {
		return productOne;
	}

		public Item getProductTwo() {
		return productTwo;
	}


	public Item getProductThree() {
		return productThree;
	}

	public Item getProductFour() {
		return productFour;
	}

	
}
