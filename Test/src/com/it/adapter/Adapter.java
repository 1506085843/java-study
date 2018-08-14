package com.it.adapter;

//适配器角色Adapter----对象级
public class Adapter implements Target{
	
	private Adaptee adaptee;
	
	public Adapter(Adaptee adaptee){
		this.adaptee = adaptee;
	}

	@Override
	public void request() {
		 adaptee.specifiRequest();
	}

}
