/*
 * https://www.tutorialspoint.com/design_pattern/flyweight_pattern.htm
 * 
 * Flyweight pattern is primarily used to reduce the number of objects created and to decrease memory footprint and increase 
 * performance. This type of design pattern comes under structural pattern as this pattern provides ways to 
 * decrease object count thus improving the object structure of application.
 * 
 * Flyweight pattern tries to reuse already existing similar kind objects by storing them and creates new object when no 
 * matching object is found. We will demonstrate this pattern by drawing 20 circles of different locations but we will create 
 * only 5 objects. Only 5 colors are available so color property is used to check already existing Circle objects..
 * 
 * Implementation
 * ---------------
 * We are going to create a Shape interface and concrete class Circle implementing the Shape interface. A factory class 
 * ShapeFactory is defined as a next step. ShapeFactory has a HashMap of Circle having key as color of the Circle object. 
 * Whenever a request comes to create a circle of particular color to ShapeFactory, it checks the circle object in its HashMap, 
 * if object of Circle found, that object is returned otherwise a new object is created, stored in hashmap for future use, 
 * and returned to client. FlyWeightPatternDemo, our demo class, will use ShapeFactory to get a Shape object. 
 * It will pass information (red / green / blue/ black / white) to ShapeFactory to get the circle of desired color it needs.
 * 
 */

package com.manas.dp.structural;

import java.util.HashMap;

public class FlyweightPattern {
	private final String colors[] = { "Red", "Green", "Blue", "White", "Black" };

	public interface Shape {
		void draw();
	}

	public class Circle implements Shape {
		private String color;
		private int x;
		private int y;
		private int radius;

		public Circle(String color) {
			this.color = color;
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}

		public void setRadius(int radius) {
			this.radius = radius;
		}

		public void draw() {
			System.out.println("Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius);
		}
	}

	public class ShapeFactory {
		private final HashMap<String, Shape> circleMap = new HashMap();

		public Shape getCircle(String color) {
			Circle circle = (Circle) circleMap.get(color);

			if (circle == null) {
				circle = new Circle(color);
				circleMap.put(color, circle);
				System.out.println("Creating circle of color : " + color);
			}
			return circle;
		}
	}

	private String getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	private static int getRandomX() {
		return (int) (Math.random() * 100);
	}

	private static int getRandomY() {
		return (int) (Math.random() * 100);
	}

	public void test() {

		for (int i = 0; i < 20; ++i) {
			Circle circle = (Circle) new ShapeFactory().getCircle(getRandomColor());
			circle.setX(getRandomX());
			circle.setY(getRandomY());
			circle.setRadius(100);
			circle.draw();
		}
	}

	public static void main(String args[]) {
		new FlyweightPattern().test();
	}

}
