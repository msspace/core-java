package com.manas.dp.creational;

import java.util.ArrayList;
import java.util.List;


//https://www.tutorialspoint.com/design_pattern/builder_pattern.htm

public class BuilderPattern {

	public interface Item {
		   public String name();
		   public Packing packing();
		   public float price();	
	}
	public interface Packing {
		   public String pack();
	}	
	public class Wrapper implements Packing {
		   public String pack() {
		      return "Wrapper";
		   }
	}
	public class Bottle implements Packing {

		   public String pack() {
		      return "Bottle";
		   }
	}
	public abstract class Burger implements Item {

		   public Packing packing() {
		      return new Wrapper();
		   }

		   public abstract float price();
	}
	public abstract class ColdDrink implements Item {

		public Packing packing() {
	       return new Bottle();
		}
		public abstract float price();
	}
	public class VegBurger extends Burger {

		   public float price() {
		      return 25.0f;
		   }

		   public String name() {
		      return "Veg Burger";
		   }
	}
	public class ChickenBurger extends Burger {
		   public float price() {
		      return 50.5f;
		   }
		   public String name() {
		      return "Chicken Burger";
		   }
	}
	public class Coke extends ColdDrink {

		   public float price() {
		      return 30.0f;
		   }

		   public String name() {
		      return "Coke";
		   }
	}
	public class Pepsi extends ColdDrink {
		   public float price() {
		      return 35.0f;
		   }
		   public String name() {
		      return "Pepsi";
		   }
	}

	public class Meal {
	   private List<Item> items = new ArrayList<Item>();	

	   public void addItem(Item item){
	      items.add(item);
	   }

	   public float getCost(){
	      float cost = 0.0f;
	      
	      for (Item item : items) {
	         cost += item.price();
	      }		
	      return cost;
	   }

	   public void showItems(){
	   
	      for (Item item : items) {
	         System.out.print("Item : " + item.name());
	         System.out.print(", Packing : " + item.packing().pack());
	         System.out.println(", Price : " + item.price());
	      }		
	   }	
	}
	public class MealBuilder {

		   public Meal prepareVegMeal (){
		      Meal meal = new Meal();
		      meal.addItem(new VegBurger());
		      meal.addItem(new Coke());
		      return meal;
		   }   

		   public Meal prepareNonVegMeal (){
		      Meal meal = new Meal();
		      meal.addItem(new ChickenBurger());
		      meal.addItem(new Pepsi());
		      return meal;
		   }
	}

   public void test() {
	   
	      MealBuilder mealBuilder = new MealBuilder();

	      Meal vegMeal = mealBuilder.prepareVegMeal();
	      System.out.println("Veg Meal");
	      vegMeal.showItems();
	      System.out.println("Total Cost: " + vegMeal.getCost());

	      Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
	      System.out.println("\n\nNon-Veg Meal");
	      nonVegMeal.showItems();
	      System.out.println("Total Cost: " + nonVegMeal.getCost());
	   }
   
   public static void main(String args[]){
	   new BuilderPattern().test();
   }
}