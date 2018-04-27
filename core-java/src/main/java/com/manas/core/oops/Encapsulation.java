package com.manas.core.oops;

public class Encapsulation {
	
	public class CricketScorer{
		//public int score =0;
		
		//A class is not a good example of encapsulation where its members
		//are public. That means the caller class can directly change its members. 
		//So making its private makes the class encapsulated.
		private int score =0;
		public int four(){
			score += 4;
			return score;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score; 
		}
		
	}
	
	public void demo(){
		CricketScorer scorer = new CricketScorer();
		System.out.println("The score is :"+scorer.getScore());
		scorer.four();
		System.out.println("The new score is :"+scorer.getScore());
	}
	
	public static void main(String args[]){
		new Encapsulation().demo();
	}

}
