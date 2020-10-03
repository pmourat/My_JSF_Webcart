package com.mywebcart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "basketsBean")
public class BasketsBean {


private  List<String> listStrings = new ArrayList<String>(); //List that contains current basket product names
private List<Item> bestList = new ArrayList<Item>(); //list that contains each product once,without duplicates

Basket basket = new Basket();

public Basket getBasket() {
	return basket;
}

public void setBasket(Basket basket) {
	this.basket = basket;
}

public List<String> getListStrings() {
	return listStrings;
}
public void setListStrings(List<String> listStrings) {
	this.listStrings = listStrings;
}
public List<Item> getBestList() {
	return bestList;
}
public void setBestList(List<Item> bestList) {
	this.bestList = bestList;
}


public double roundPrice(double tp) {
	double roundOff = Math.round(tp * 100.0) / 100.0;
return roundOff;
	
}






public  double getCheckOutFinalPrice() {
    basket.setCheckOutPrice(roundPrice(basket.getTotalPrice()) + (5* basket.getTotalWeightFactor()));
    double roundOff = Math.round(basket.getCheckOutPrice() * 100.0) / 100.0;
   	
return roundOff;
}





public  void add(Item g){
    
    basket.setTotalItems(basket.getTotalItems()+1);

    if (((basket.getTotalPrice()+g.getPrice()) >=100) && (!basket.getFlag())){
        
        basket.setFlag(true);
        basket.setTotalPrice((basket.getTotalPrice() +g.getPrice()) *0.9);
        }
    else if((((basket.getTotalPrice()+ g.getPrice()) >=100) && (basket.getFlag())))
    {
       
    	basket.setTotalPrice(basket.getTotalPrice() + g.getPrice()*0.9);
        	
        }
    else
    {
    	basket.setTotalPrice( basket.getTotalPrice() + g.getPrice());
    }
    basket.setTotalWeightFactor( basket.getTotalWeightFactor() + g.getWeightFactor());
   
    if (count(g)==0){
    	bestList.add(g);
    	 }
    listStrings.add(g.getName());


    
}






public  void remove(Item g){
    if (listStrings.contains(g.getName())) {
    	basket.setTotalItems(basket.getTotalItems()-1);
     
        if ((((basket.getTotalPrice()/0.9 - g.getPrice())) >= 100) && (basket.getFlag())){
          
        	basket.setTotalPrice(basket.getTotalPrice() - g.getPrice()*0.9);
        }
        else if ((basket.getFlag())&& (((basket.getTotalPrice()/0.9 - g.getPrice()) <100)) ){
        	basket.setTotalPrice(basket.getTotalPrice()/0.9 - g.getPrice());
        	 
        	basket.setFlag(false);
        }
        else
        {
        	basket.setTotalPrice(basket.getTotalPrice() - g.getPrice());
        	
        }
        basket.setTotalWeightFactor( basket.getTotalWeightFactor() - g.getWeightFactor());
        if (count(g)==1){
        bestList.remove(g); 
        }
        listStrings.remove(g.getName());
      
 
    }
         
}




public  void clear(){
    listStrings.clear();
    basket.setTotalItems(0);
    basket.setTotalPrice(0);
    basket.setFlag(false);
    basket.setTotalWeightFactor(0);
    basket.setCheckOutPrice(0);
    bestList.clear();
}


public int count(Item g) {
	
	int find = Collections.frequency(listStrings, g.getName());
	return find;
}


public void removeDuplicates(List<Item >yourList) {
	
	Set <Item> set = new HashSet<>(yourList);			//function to remove duplicates from my list (bestList)
	yourList.clear();
	yourList.addAll(set);
}

public String discountMessage(boolean result) {
String message="";
if(result) {
	
	message="DiscountApplied";
}

return message;
}


}

