package com.Spring.Tut14LifeCycleCallback;

import java.util.List;

/**
 * @author Gaurav Sharma
 *
 */
public class TriangleList {

	private List<Point> points ; 
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw()
	{
		for(Point p:points){
			System.out.println("Point (x,y):: " +p.getx()+ "," +p.gety());
		}
	}

	
}
