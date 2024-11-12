package test;

import java.io.Serializable;

public class cal implements Serializable
{
	private int a = 1;
	private int b = 2;
	
	public int plus(int a, int b) 
	{
		return a+b;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
}
