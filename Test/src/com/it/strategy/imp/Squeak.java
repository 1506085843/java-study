package com.it.strategy.imp;

import com.it.strategy.inf.QuackBehavior;

public class Squeak implements QuackBehavior {

	@Override
	public void Quack() {
       System.out.println("实现吱吱叫的鸭子");
	}

}
