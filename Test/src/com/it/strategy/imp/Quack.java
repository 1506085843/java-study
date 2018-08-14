package com.it.strategy.imp;

import com.it.strategy.inf.QuackBehavior;

public class Quack implements QuackBehavior {

	@Override
	public void Quack() {
	 System.out.println("实现呱呱叫的鸭子");
	}

}
