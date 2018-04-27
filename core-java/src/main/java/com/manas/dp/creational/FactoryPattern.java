/*
 * https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 * 
 * Factory pattern is one of the most used design patterns in Java. This type of design pattern comes 
 * under creational pattern as this pattern provides one of the best ways to create an object.
 * 
 * In Factory pattern, we create object without exposing the creation logic to the client and 
 * refer to newly created object using a common interface.
 * 
 * Implementation:
 * ---------------
 * We're going to create a Shape interface and concrete classes implementing the Shape interface. 
 * A factory class ShapeFactory is defined as a next step.
 * 
 * FactoryPatternDemo, our demo class will use ShapeFactory to get a Shape object. 
 * It will pass information (CIRCLE / RECTANGLE / SQUARE) to ShapeFactory to get the type of object 
 * it needs.
 * 
 * 
 * Practical Usage:
 * ---------------
 * 1.	If you are using large chunk of if/else or switch statement in your code to create instances 
 * 	  	of similar classes. You may have seen the problem, which is every time when you introduce 
 * 		a new class.
 */

package com.manas.dp.creational;

public class FactoryPattern {

	public interface Shape {
		void draw();
	}

	public class Rectangle implements Shape {

		public void draw() {
			System.out.println("Inside Rectangle::draw() method.");
		}
	}

	public class Square implements Shape {

		public void draw() {
			System.out.println("Inside Square::draw() method.");
		}
	}

	public class Circle implements Shape {

		public void draw() {
			System.out.println("Inside Circle::draw() method.");
		}
	}

	public class ShapeFactory {

		// use getShape method to get object of type shape
		public Shape getShape(String shapeType) {
			if (shapeType == null) {
				return null;
			}
			if (shapeType.equalsIgnoreCase("CIRCLE")) {
				return new Circle();

			} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
				return new Rectangle();

			} else if (shapeType.equalsIgnoreCase("SQUARE")) {
				return new Square();
			}

			return null;
		}
	}

	public void test() {

		ShapeFactory shapeFactory = new ShapeFactory();

		// get an object of Circle and call its draw method.
		Shape shape1 = shapeFactory.getShape("CIRCLE");

		// call draw method of Circle
		shape1.draw();

		// get an object of Rectangle and call its draw method.
		Shape shape2 = shapeFactory.getShape("RECTANGLE");

		// call draw method of Rectangle
		shape2.draw();

		// get an object of Square and call its draw method.
		Shape shape3 = shapeFactory.getShape("SQUARE");

		// call draw method of circle
		shape3.draw();
	}

	public static void main(String args[]) {
		new FactoryPattern().test();
	}

}
