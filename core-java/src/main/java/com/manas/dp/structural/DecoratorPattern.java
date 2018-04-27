/*
 * https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm
 *
 * Decorator pattern allows a user to add new functionality to an existing object without altering its 
 * structure. This type of design pattern comes under structural pattern as this pattern acts as a 
 * wrapper to existing class. This pattern creates a decorator class which wraps the original class and 
 * provides additional functionality keeping class methods signature intact. We are demonstrating the use 
 * of decorator pattern via following example in which we will decorate a shape with some color without 
 * alter shape class. 
 * 
 * Implementation
 * ---------------
 * We're going to create a Shape interface and concrete classes implementing the Shape interface. 
 * We will then create an abstract decorator class ShapeDecorator implementing the Shape interface 
 * and having Shape object as its instance variable. RedShapeDecorator is concrete class implementing 
 * ShapeDecorator. 
 */

package com.manas.dp.structural;

public class DecoratorPattern {

	public interface Shape {
		void draw();
	}

	public class Rectangle implements Shape {

		public void draw() {
			System.out.println("Shape: Rectangle");
		}
	}

	public class Circle implements Shape {

		public void draw() {
			System.out.println("Shape: Circle");
		}
	}

	public abstract class ShapeDecorator implements Shape {
		protected Shape decoratedShape;

		public ShapeDecorator(Shape decoratedShape) {
			this.decoratedShape = decoratedShape;
		}

		public void draw() {
			decoratedShape.draw();
		}
	}

	public class RedShapeDecorator extends ShapeDecorator {

		public RedShapeDecorator(Shape decoratedShape) {
			super(decoratedShape);
		}

		@Override
		public void draw() {
			decoratedShape.draw();
			setRedBorder(decoratedShape);
		}

		private void setRedBorder(Shape decoratedShape) {
			System.out.println("Border Color: Red");
		}
	}

	public void test() {
		Shape circle = new Circle();

		Shape redCircle = new RedShapeDecorator(new Circle());

		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}

	public static void main(String args[]) {
		new DecoratorPattern().test();
	}

}
