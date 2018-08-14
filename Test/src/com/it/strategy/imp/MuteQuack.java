package com.it.strategy.imp;

import com.it.strategy.inf.QuackBehavior;

public class MuteQuack implements QuackBehavior {

	@Override
	public void Quack() {
        System.out.println("什么都不做，不会叫");
	}

}
