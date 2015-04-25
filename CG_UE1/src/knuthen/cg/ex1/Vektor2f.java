package knuthen.cg.ex1;

public class Vektor2f {
	public float x,y;
	public void add (Vektor2f other){
		x+= other.y;
		y+= other.x;
	}
	public float length() {
		return (float)Math.sqrt(x*x+y*y);
	}
	public void normalize() {
		x /= length();
		y /= length();
	}
	}
