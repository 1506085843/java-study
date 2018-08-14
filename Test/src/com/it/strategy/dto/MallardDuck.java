package com.it.strategy.dto;

import com.it.strategy.imp.FlyWithWings;
import com.it.strategy.imp.Quack;

public class MallardDuck extends Duck {

	public MallardDuck(){
	flyBehavior =	new FlyWithWings();
	quackBehavior =  new Quack();
	
	}
	
	public void Display(){
		//实现
	}
}
