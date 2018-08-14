package com.it.factory.imp;

import com.it.factory.inf.Food;

/**
 * 薯条对抽象接口的实现
 * 
 * @author Hosiang
 *
 */
public class Chips implements Food {
    
	//获取一份薯条
	@Override
	public void get() {
		System.out.println("我要一份薯条");
	}

}
