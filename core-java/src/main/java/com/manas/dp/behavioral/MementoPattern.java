/*
 * https://www.tutorialspoint.com/design_pattern/memento_pattern.htm
 *
 * Memento pattern is used to restore state of an object to a previous state. 
 * 
 * Implementation:
 * ---------------
 * Memento pattern uses three actor classes. Memento contains state of an object to be restored. 
 * Originator creates and stores states in Memento objects and Caretaker object is responsible 
 * to restore object state from Memento. We have created classes Memento, Originator and CareTaker. 
 * 
 * 
 * Practical Usage:
 * ---------------
 * 
 */

package com.manas.dp.behavioral;

import java.util.ArrayList;
import java.util.List;

public class MementoPattern {

	public class Memento {
		private String state;

		public Memento(String state) {
			this.state = state;
		}

		public String getState() {
			return state;
		}
	}

	public class Originator {
		private String state;

		public void setState(String state) {
			this.state = state;
		}

		public String getState() {
			return state;
		}

		public Memento saveStateToMemento() {
			return new Memento(state);
		}

		public void getStateFromMemento(Memento memento) {
			state = memento.getState();
		}
	}

	public class CareTaker {
		private List<Memento> mementoList = new ArrayList<Memento>();

		public void add(Memento state) {
			mementoList.add(state);
		}

		public Memento get(int index) {
			return mementoList.get(index);
		}
	}

	// Use the context to see change in behavior when state changes
	public void test() {
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();

		originator.setState("State #1");
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #3");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #4");
		System.out.println("Current State: " + originator.getState());

		originator.getStateFromMemento(careTaker.get(0));
		System.out.println("First saved State: " + originator.getState());
		originator.getStateFromMemento(careTaker.get(1));
		System.out.println("Second saved State: " + originator.getState());
	}

	public static void main(String[] args) {
		new MementoPattern().test();
	}
}
