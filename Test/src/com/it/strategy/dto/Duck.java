package com.it.strategy.dto;

import com.it.strategy.inf.FlyBehavior;
import com.it.strategy.inf.QuackBehavior;

public class Duck {
	
	String Display;
    FlyBehavior flyBehavior;//接口
    QuackBehavior quackBehavior;//接口
   
    public Duck(){}
    public void Display(){}
    public void Swim(){
    //实现游泳的行为
    }
    
    public void performFly(){
        flyBehavior.Fly(); // -->由于是接口,会根据继承类实现的方式,而调用相应的方法.
    }
     public void performQuack(){
          quackBehavior.Quack();
    }
	public FlyBehavior getFlyBehavior() {
		return flyBehavior;
	}
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
	public QuackBehavior getQuackBehavior() {
		return quackBehavior;
	}
	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
     
     
}
