/*
 * https://www.tutorialspoint.com/design_pattern/visitor_pattern.htm
 *
 * In Visitor pattern, we use a visitor class which changes the executing algorithm of an element class. 
 * By this way, execution algorithm of element can vary as and when visitor varies. This pattern 
 * comes under behavior pattern category. As per the pattern, element object has to accept the visitor 
 * object so that visitor object handles the operation on the element object. 
 * 
 * Implementation:
 * ---------------
 * We are going to create a ComputerPart interface defining accept opearation.Keyboard, Mouse, Monitor 
 * and Computer are concrete classes implementing ComputerPart interface. We will define another interface 
 * ComputerPartVisitor which will define a visitor class operations. Computer uses concrete visitor to 
 * do corresponding action.
 * 
 * 
 * Practical Usage:
 * ---------------
 * 1.	If you are using large chunk of if/else or switch statement in your code to create instances 
 * 	  	of similar classes. You may have seen the problem, which is every time when you introduce 
 * 		a new class.
 */

package com.manas.dp.behavioral;

public class VisitorPattern {
	public interface ComputerPart {
		public void accept(ComputerPartVisitor computerPartVisitor);
	}

	//Concrete classes accepting the visitor.
	public class Keyboard implements ComputerPart {

		public void accept(ComputerPartVisitor computerPartVisitor) {
			computerPartVisitor.visit(this);
		}
	}

	public class Monitor implements ComputerPart {

		public void accept(ComputerPartVisitor computerPartVisitor) {
			computerPartVisitor.visit(this);
		}
	}

	public class Mouse implements ComputerPart {

		public void accept(ComputerPartVisitor computerPartVisitor) {
			computerPartVisitor.visit(this);
		}
	}

	public class Computer implements ComputerPart {

		ComputerPart[] parts;

		public Computer() {
			parts = new ComputerPart[] { new Mouse(), new Keyboard(), new Monitor() };
		}

		public void accept(ComputerPartVisitor computerPartVisitor) {
			for (int i = 0; i < parts.length; i++) {
				parts[i].accept(computerPartVisitor);
			}
			computerPartVisitor.visit(this);
		}
	}

	public interface ComputerPartVisitor {
		public void visit(Computer computer);

		public void visit(Mouse mouse);

		public void visit(Keyboard keyboard);

		public void visit(Monitor monitor);
	}

	public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

		public void visit(Computer computer) {
			System.out.println("Displaying Computer.");
		}

		public void visit(Mouse mouse) {
			System.out.println("Displaying Mouse.");
		}

		public void visit(Keyboard keyboard) {
			System.out.println("Displaying Keyboard.");
		}

		public void visit(Monitor monitor) {
			System.out.println("Displaying Monitor.");
		}
	}

	public void test() {
		ComputerPart computer = new Computer();
		computer.accept(new ComputerPartDisplayVisitor());
	}

	public static void main(String[] args) {
		new VisitorPattern().test();
	}
}
