package com.it.adapter;

//类级适配器HeavyAdapter---类级
public class HeavyAdapter extends Adaptee implements Target{

	@Override
	public void request() {
		this.specifiRequest();
	}
}
