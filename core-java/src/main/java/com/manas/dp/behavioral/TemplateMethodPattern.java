/*
 * https://www.tutorialspoint.com/design_pattern/template_pattern.htm
 *
 * In Template pattern, an abstract class exposes defined way(s)/template(s) to execute its methods. 
 * Its subclasses can override the method implementation as per need but the invocation is to be in 
 * the same way as defined by an abstract class. This pattern comes under behavior pattern category.
 * 
 * Implementation
 * ---------------
 * We are going to create a Game abstract class defining operations with a template method 
 * set to be final so that it cannot be overridden. Cricket and Football are concrete classes 
 * that extend Game and override its methods.
 */

package com.manas.dp.behavioral;

public class TemplateMethodPattern {

	//Abstract class with a template method being final.
	public abstract class Game {
		   abstract void initialize();
		   abstract void startPlay();
		   abstract void endPlay();

		   //template method
		   public final void play(){
		      initialize();
		      startPlay();
		      endPlay();
		   }
		}

	//Concrete class
	public class Cricket extends Game {

		   @Override
		   void endPlay() {
		      System.out.println("Cricket Game Finished!");
		   }

		   @Override
		   void initialize() {
		      System.out.println("Cricket Game Initialized! Start playing.");
		   }

		   @Override
		   void startPlay() {
		      System.out.println("Cricket Game Started. Enjoy the game!");
		   }
		}

	//Concrete class
	public class Football extends Game {

		   @Override
		   void endPlay() {
		      System.out.println("Football Game Finished!");
		   }

		   @Override
		   void initialize() {
		      System.out.println("Football Game Initialized! Start playing.");
		   }

		   @Override
		   void startPlay() {
		      System.out.println("Football Game Started. Enjoy the game!");
		   }
		}



	public void test() {
	      Game game = new Cricket();
	      game.play();
	      System.out.println();
	      game = new Football();
	      game.play();	
	}

	public static void main(String[] args) {
		new TemplateMethodPattern().test();
	}
}
