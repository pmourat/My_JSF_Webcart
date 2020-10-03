package com.mywebcart;

import javax.faces.bean.SessionScoped;

@SessionScoped
public class Basket {
	
	private  int totalItems;
    private  double totalPrice;
    private  double checkOutPrice;
    private  double totalWeightFactor;
    private  boolean flag ;         //flag to apply the discount once   	
   
	


	public  double getTotalWeightFactor() {
        return totalWeightFactor;
    }

	
	public void setTotalWeightFactor(double totalWeightFactor) {
        this.totalWeightFactor = totalWeightFactor;
    }

    public  int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public  double getTotalPrice() {
    		
            return totalPrice;
        }


    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public double getCheckOutPrice() {
    	
    	return checkOutPrice;
    }


    public void setCheckOutPrice(double checkOutPrice) {
        this.checkOutPrice = checkOutPrice;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
   