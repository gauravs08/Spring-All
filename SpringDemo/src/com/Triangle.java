package com;


/**
 * @author Gaurav Sharma
 *
 */
public class Triangle {

	public Triangle(int height) {
		this.height = height;
		
	}
	public Triangle(String type) {
		this.type = type;
		
	}
	private String type;
	private int height;
	//this property "type" is already set in SpringDraw.xml so objBean will
	//always have default value type= "Equilateral"
	
	//Setting type,height value by constructor in SpringDraw.xml using <constructor-args....>
	public Triangle(String type, int height) {
		this.type = type;
		this.height = height;
	}
	public void draw()
	{
		System.out.println(getType() +" Triangle Draw of height " +getHeight());
	}

	public String getType() {
		return type;
	}
	public int getHeight() {
		return height;
	}
	
	// set methods job is done by constructor in xml
	/*public void setHeight(int height) {
		this.height = height;
	}

	public void setType(String type) {
		this.type = type;
	}*/
}
