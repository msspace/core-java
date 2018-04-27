/*
 * https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm
 * 
 * Abstract Factory patterns work around a super-factory which creates other factories. 
 * This factory is also called as factory of factories. This type of design pattern comes 
 * under creational pattern as this pattern provides one of the best ways to 
 * create an object.

 * In Abstract Factory pattern an interface is responsible for creating a factory of related 
 * objects without explicitly specifying their classes. Each generated factory can give 
 * the objects as per the Factory pattern.
 * 
 * Implementation:
 * ---------------
 * We are going to create a Shape and Color interfaces and concrete classes implementing 
 * these interfaces. We create an abstract factory class AbstractFactory as next step. 
 * Factory classes ShapeFactory and ColorFactory are defined where each factory extends 
 * AbstractFactory. A factory creator/generator class FactoryProducer is created.

 * AbstractFactoryPatternDemo, our demo class uses FactoryProducer to get a AbstractFactory 
 * object. It will pass information (CIRCLE / RECTANGLE / SQUARE for Shape) to 
 * AbstractFactory to get the type of object it needs. It also passes information 
 * (RED / GREEN / BLUE for Color) to AbstractFactory to get the type of object it needs..
 * 
 * 
 * Practical Usage:
 * ---------------
 * 1.	If you are using large chunk of if/else or switch statement in your code to create instances 
 * 	  	of similar classes. You may have seen the problem, which is every time when you introduce 
 * 		a new class.
 */

package com.manas.dp.creational;

public class AbstractFactoryPattern {

	//Create interface for Shapes
	public interface Shape {
		void draw();
	}

	//Concrete classes implementing shapes.
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
	
	//Interface for Colors.
	public interface Color {
		   void fill();
	}

	//Concrete classes for colors
	public class Red implements Color {

		   public void fill() {
		      System.out.println("Inside Red::fill() method.");
		   }
	}
	
	public class Green implements Color {

		   public void fill() {
		      System.out.println("Inside Green::fill() method.");
		   }
	}
	
	public class Blue implements Color {

		   public void fill() {
		      System.out.println("Inside Blue::fill() method.");
		   }
	}
	
	//Abstract class to get factories for Color and Shape objects.
	public abstract class AbstractFactory {
		   abstract Color getColor(String color);
		   abstract Shape getShape(String shape) ;
	}
	
	//Create Factory classes to generate object of concrete class.
	public class ShapeFactory extends AbstractFactory {

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
		   @Override
		   Color getColor(String color) {
		      return null;
		   }
	}
	
	public class ColorFactory extends AbstractFactory {
		
		   @Override
		   public Shape getShape(String shapeType){
		      return null;
		   }
		   
		   @Override
		   Color getColor(String color) {
		   
		      if(color == null){
		         return null;
		      }		
		      
		      if(color.equalsIgnoreCase("RED")){
		         return new Red();
		         
		      }else if(color.equalsIgnoreCase("GREEN")){
		         return new Green();
		         
		      }else if(color.equalsIgnoreCase("BLUE")){
		         return new Blue();
		      }
		      
		      return null;
		   }
	}

	public class FactoryProducer {
		   public AbstractFactory getFactory(String choice){
		   
		      if(choice.equalsIgnoreCase("SHAPE")){
		         return new ShapeFactory();
		         
		      }else if(choice.equalsIgnoreCase("COLOR")){
		         return new ColorFactory();
		      }
		      
		      return null;
		   }
	}
	
	public void test() {

	      //get shape factory
	      AbstractFactory shapeFactory = new FactoryProducer().getFactory("SHAPE");

	      //get an object of Shape Circle
	      Shape shape1 = shapeFactory.getShape("CIRCLE");

	      //call draw method of Shape Circle
	      shape1.draw();

	      //get an object of Shape Rectangle
	      Shape shape2 = shapeFactory.getShape("RECTANGLE");

	      //call draw method of Shape Rectangle
	      shape2.draw();
	      
	      //get an object of Shape Square 
	      Shape shape3 = shapeFactory.getShape("SQUARE");

	      //call draw method of Shape Square
	      shape3.draw();

	      //get color factory
	      AbstractFactory colorFactory = new FactoryProducer().getFactory("COLOR");

	      //get an object of Color Red
	      Color color1 = colorFactory.getColor("RED");

	      //call fill method of Red
	      color1.fill();

	      //get an object of Color Green
	      Color color2 = colorFactory.getColor("Green");

	      //call fill method of Green
	      color2.fill();

	      //get an object of Color Blue
	      Color color3 = colorFactory.getColor("BLUE");

	      //call fill method of Color Blue
	      color3.fill();
	}

	public static void main(String args[]) {
		new AbstractFactoryPattern().test();
	}

}
