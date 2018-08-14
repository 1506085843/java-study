package com.it.factory.imp;

import com.it.factory.inf.Food;

/**
 * 麦香鸡对抽象产品接口的实现
 * 
 * @author Hosiang
 *
 */
public class McChicken implements Food {
   
	//获取一份麦香鸡
	@Override
	public void get() {
     System.out.println("我要一份麦香鸡");
	}

}
