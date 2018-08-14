package com.it.factory;

import com.it.factory.imp.Chips;
import com.it.factory.imp.McChicken;
import com.it.factory.inf.Food;

public class FoodFactory {

	public static Food getFood(String type)throws InstantiationException,
	IllegalAccessException,ClassNotFoundException{
		
		if (type.equalsIgnoreCase("mcchicken")) {
			return McChicken.class.newInstance();
		}else if (type.equalsIgnoreCase("chips")) {
			return Chips.class.newInstance();
		}else{
			System.out.println("找不到相应的实例化类！！");
			return null;
		}
		
	}
}
