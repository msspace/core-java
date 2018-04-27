/*
 * https://www.tutorialspoint.com/design_pattern/state_pattern.htm
 *
 * Interpreter pattern provides a way to evaluate language grammar or expression. This pattern involves 
 * implementing an expression interface which tells to interpret a particular context. This pattern is used 
 * in SQL parsing, symbol processing engine etc. 
 * 
 * Implementation:
 * ---------------
 * We are going to create an interface Expression and concrete classes implementing the Expression 
 * interface. A class TerminalExpression is defined which acts as a main interpreter of context in question. 
 * Other classes OrExpression, AndExpression are used to create combinational expressions.
 * 
 * Practical Usage:
 * ---------------
 * 
 */

package com.manas.dp.behavioral;

public class InterpreterPattern {

	public interface Expression {
		public boolean interpret(String context);
	}

	public class TerminalExpression implements Expression {

		private String data;

		public TerminalExpression(String data) {
			this.data = data;
		}

		public boolean interpret(String context) {

			if (context.contains(data)) {
				return true;
			}
			return false;
		}
	}

	public class OrExpression implements Expression {

		private Expression expr1 = null;
		private Expression expr2 = null;

		public OrExpression(Expression expr1, Expression expr2) {
			this.expr1 = expr1;
			this.expr2 = expr2;
		}

		public boolean interpret(String context) {
			return expr1.interpret(context) || expr2.interpret(context);
		}
	}

	public class AndExpression implements Expression {

		private Expression expr1 = null;
		private Expression expr2 = null;

		public AndExpression(Expression expr1, Expression expr2) {
			this.expr1 = expr1;
			this.expr2 = expr2;
		}

		public boolean interpret(String context) {
			return expr1.interpret(context) && expr2.interpret(context);
		}
	}

	// Rule: Robert and John are male
	public Expression getMaleExpression() {
		Expression robert = new TerminalExpression("Robert");
		Expression john = new TerminalExpression("John");
		return new OrExpression(robert, john);
	}

	// Rule: Julie is a married women
	public Expression getMarriedWomanExpression() {
		Expression julie = new TerminalExpression("Julie");
		Expression married = new TerminalExpression("Married");
		return new AndExpression(julie, married);
	}

	// Use the context to see change in behavior when state changes
	public void test() {
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomanExpression();
		System.out.println("John is male? " + isMale.interpret("John"));
		System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));
	}

	public static void main(String[] args) {
		new InterpreterPattern().test();
	}
}
