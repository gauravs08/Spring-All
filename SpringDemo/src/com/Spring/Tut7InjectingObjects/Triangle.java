package com.Spring.Tut7InjectingObjects;

public class Triangle {

	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	
	public void draw()
	{
		System.out.println("PointA (x,y):: " +getPointA().getx()+ "," +getPointA().gety());
		System.out.println("PointB (x,y):: " +getPointB().getx()+ "," +getPointB().gety());
		System.out.println("PointC (x,y):: " +getPointC().getx()+ "," +getPointC().gety());
	}
	
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	
}
