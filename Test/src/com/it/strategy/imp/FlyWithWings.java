package com.it.strategy.imp;

import com.it.strategy.inf.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void Fly() {
      System.out.println("实现了所有有翅膀的鸭子飞行行为");
	}

}
