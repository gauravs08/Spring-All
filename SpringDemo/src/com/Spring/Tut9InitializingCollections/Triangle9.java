package com.Spring.Tut9InitializingCollections;

import java.util.List;

/**
 * @author Gaurav Sharma
 *
 */
public class Triangle9 {

	/*private Point pointA;
	private Point pointB;
	private Point pointC;*/
	
	private List<Point9> points ; 
	
	public List<Point9> getPoints() {
		return points;
	}

	public void setPoints(List<Point9> points) {
		this.points = points;
	}

	public void draw()
	{
		for(Point9 p:points){
			System.out.println("Point (x,y):: " +p.getx()+ "," +p.gety());
		}
		/*
		System.out.println("PointA (x,y):: " +getPointA().getx()+ "," +getPointA().gety());
		System.out.println("PointB (x,y):: " +getPointB().getx()+ "," +getPointB().gety());
		System.out.println("PointC (x,y):: " +getPointC().getx()+ "," +getPointC().gety());*/
	}
	
	/*public Point getPointA() {
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
	}*/

	
}
