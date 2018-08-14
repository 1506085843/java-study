package com.it.strategy.imp;

import com.it.strategy.inf.FlyBehavior;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void Fly() {
        System.out.println("什么都不做，不会飞");
	}

}
