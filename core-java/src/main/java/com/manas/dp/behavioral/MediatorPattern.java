/*
 * https://www.tutorialspoint.com/design_pattern/mediator_pattern.htm
 *
 * Mediator pattern is used to reduce communication complexity between multiple objects or classes. 
 * This pattern provides a mediator class which normally handles all the communications between 
 * different classes and supports easy maintenance of the code by loose coupling. 
 * Mediator pattern falls under behavioral pattern category.
 * 
 * Implementation
 * ---------------
 * We are demonstrating mediator pattern by example of a chat room where multiple users 
 * can send message to chat room and it is the responsibility of chat room to show the 
 * messages to all users. We have created two classes ChatRoom and User. User objects will 
 * use ChatRoom method to share their messages.
 */

package com.manas.dp.behavioral;

import java.util.Date;

public class MediatorPattern {

	public class ChatRoom {
		public void showMessage(User user, String message) {
			System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
		}
	}

	public class User {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public User(String name) {
			this.name = name;
		}

		public void sendMessage(String message) {
			new ChatRoom().showMessage(this, message);
		}
	}

	public void test() {
		User robert = new User("Robert");
		User john = new User("John");

		robert.sendMessage("Hi! John!");
		john.sendMessage("Hello! Robert!");
	}

	public static void main(String[] args) {
		new MediatorPattern().test();
	}
}
