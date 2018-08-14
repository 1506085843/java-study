package com.it.factory;

import com.it.factory.inf.Food;

/**
 * 测试
 * 
 * @author Hosaing
 *
 */
public class SimpleFactoryTest {
	
	public static void main(String[] args)throws InstantiationException,
	IllegalAccessException,ClassNotFoundException {
		
		//实例化各种食物
		Food mcChicken = FoodFactory.getFood("McChicken");
		Food chips = FoodFactory.getFood("Chips");
		Food eggs = FoodFactory.getFood("Eggs");
		
		if (null != mcChicken) {
			mcChicken.get();
		}
		
		if (null != chips) {
			chips.get();
		}
		
		if (null != eggs) {
			chips.get();
		}
	}
}
