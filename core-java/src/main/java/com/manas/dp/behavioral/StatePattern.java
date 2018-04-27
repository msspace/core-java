/*
 * https://www.tutorialspoint.com/design_pattern/state_pattern.htm
 *
 * In State pattern a class behavior changes based on its state. In State pattern, we create objects which 
 * represent various states and a context object whose behavior varies as its state object changes. 
 * 
 * Implementation:
 * ---------------
 * We are going to create a State interface defining an action and concrete state classes 
 * implementing the State interface. Context is a class which carries a State.
 * StatePatternDemo, our demo class, will use Context and state objects to 
 * demonstrate change in Context behavior based on type of state it is in.
 * 
 * 
 * Practical Usage:
 * ---------------
 * 
 */

package com.manas.dp.behavioral;

public class StatePattern {

	public interface State {
		public void doAction(Context context);
	}

	public class StartState implements State {

		public void doAction(Context context) {
			System.out.println("Player is in start state");
			context.setState(this);
		}

		public String toString() {
			return "Start State";
		}
	}

	public class StopState implements State {

		public void doAction(Context context) {
			System.out.println("Player is in stop state");
			context.setState(this);
		}

		public String toString() {
			return "Stop State";
		}
	}

	public class Context {
		private State state;

		public Context() {
			state = null;
		}

		public void setState(State state) {
			this.state = state;
		}

		public State getState() {
			return state;
		}
	}

	// Use the context to see change in behavior when state changes
	public void test() {
		Context context = new Context();

		StartState startState = new StartState();
		startState.doAction(context);

		System.out.println(context.getState().toString());

		StopState stopState = new StopState();
		stopState.doAction(context);

		System.out.println(context.getState().toString());
	}

	public static void main(String[] args) {
		new StatePattern().test();
	}
}
