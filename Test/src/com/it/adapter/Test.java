package com.it.adapter;

public class Test {
	public static void main(String[] args) {
		/*对象级适配器的使用*/
		Adaptee adaptee = new Adaptee();
		Target tar = new Adapter(adaptee);
		tar.request();
		/*类级适配器的使用*/
		Target hTar = new HeavyAdapter();
		hTar.request();
	}
}
