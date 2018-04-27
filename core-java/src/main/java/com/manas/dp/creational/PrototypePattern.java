/*
 * https://www.tutorialspoint.com/design_pattern/prototype_pattern.htm
 * 
 * Prototype pattern refers to creating duplicate object while keeping performance in mind. 
 * This type of design pattern comes under creational pattern as this pattern 
 * provides one of the best ways to create an object.
 * 
 * This pattern involves implementing a prototype interface which tells to create 
 * a clone of the current object. This pattern is used when creation of object directly 
 * is costly. For example, an object is to be created after a costly database operation. 
 * We can cache the object, returns its clone on next request and update the database 
 * as and when needed thus reducing database calls.
 * 
 * Implementation:
 * ---------------
 * We're going to create an abstract class Shape and concrete classes extending the Shape class. 
 * A class ShapeCache is defined as a next step which stores shape objects in a Hashtable 
 * and returns their clone when requested.
 * 
 * Practical Usage:
 * ---------------
 * 1.	If you are using large chunk of if/else or switch statement in your code to create instances 
 * 	  	of similar classes. You may have seen the problem, which is every time when you introduce 
 * 		a new class.
 */

package com.manas.dp.creational;

import java.util.Hashtable;

public class PrototypePattern {

	public abstract class Shape implements Cloneable {
		   
		   private String id;
		   protected String type;
		   
		   abstract void draw();
		   
		   public String getType(){
		      return type;
		   }
		   
		   public String getId() {
		      return id;
		   }
		   
		   public void setId(String id) {
		      this.id = id;
		   }
		   
		   public Object clone() {
		      Object clone = null;
		      
		      try {
		         clone = super.clone();
		         
		      } catch (CloneNotSupportedException e) {
		         e.printStackTrace();
		      }
		      
		      return clone;
		   }
		}
	
	public class Rectangle extends Shape {

		   public Rectangle(){
		     type = "Rectangle";
		   }

		   @Override
		   public void draw() {
		      System.out.println("Inside Rectangle::draw() method.");
		   }
		}
	
	public class Square extends Shape {

		   public Square(){
		     type = "Square";
		   }

		   @Override
		   public void draw() {
		      System.out.println("Inside Square::draw() method.");
		   }
		}
	
	public class Circle extends Shape {

		   public Circle(){
		     type = "Circle";
		   }

		   @Override
		   public void draw() {
		      System.out.println("Inside Circle::draw() method.");
		   }
		}
	
	public class ShapeCache {
		
		   private Hashtable<String, Shape> shapeMap  = new Hashtable<String, Shape>();

		   public Shape getShape(String shapeId) {
		      Shape cachedShape = shapeMap.get(shapeId);
		      return (Shape) cachedShape.clone();
		   }

		   // for each shape run database query and create shape
		   // shapeMap.put(shapeKey, shape);
		   // for example, we are adding three shapes
		   
		   public void loadCache() {
		      Circle circle = new Circle();
		      circle.setId("1");
		      shapeMap.put(circle.getId(),circle);

		      Square square = new Square();
		      square.setId("2");
		      shapeMap.put(square.getId(),square);

		      Rectangle rectangle = new Rectangle();
		      rectangle.setId("3");
		      shapeMap.put(rectangle.getId(), rectangle);
		   }
		}
	
	public void test() {

		ShapeCache shapeCache = new ShapeCache();
		shapeCache.loadCache();

	      Shape clonedShape = (Shape) shapeCache.getShape("1");
	      System.out.println("Shape : " + clonedShape.getType());		

	      Shape clonedShape2 = (Shape) shapeCache.getShape("2");
	      System.out.println("Shape : " + clonedShape2.getType());		

	      Shape clonedShape3 = (Shape) shapeCache.getShape("3");
	      System.out.println("Shape : " + clonedShape3.getType());	
	}

	public static void main(String args[]) {
		new PrototypePattern().test();
	}

}
