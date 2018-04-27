/*
 * https://www.tutorialspoint.com/design_pattern/iterator_pattern.htm
 *
 * Iterator pattern is very commonly used design pattern in Java and .Net programming environment. 
 * This pattern is used to get a way to access the elements of a collection object in sequential 
 * manner without any need to know its underlying representation. 
 * 
 * Implementation:
 * ---------------
 * We're going to create a Iterator interface which narrates navigation method and a Container interface 
 * which retruns the iterator . Concrete classes implementing the Container interface will be responsible 
 * to implement Iterator interface and use it 
 * 
 * 
 * Practical Usage:
 * ---------------
 * 
 */

package com.manas.dp.behavioral;

public class IteratorPattern {

	public interface Iterator {
		public boolean hasNext();
		public Object next();
	}

	public interface Container {
		public Iterator getIterator();
	}

	//Create concrete class implementing the Container interface. 
	//This class has inner class NameIterator implementing the Iterator interface.
	public class NameRepository implements Container {
		public String names[] = { "Robert", "John", "Julie", "Lora" };

		public Iterator getIterator() {
			return new NameIterator();
		}

		private class NameIterator implements Iterator {

			int index;

			public boolean hasNext() {

				if (index < names.length) {
					return true;
				}
				return false;
			}

			public Object next() {

				if (this.hasNext()) {
					return names[index++];
				}
				return null;
			}
		}
	}

	// Use the context to see change in behavior when state changes
	public void test() {
		NameRepository namesRepository = new NameRepository();

		for (Iterator iter = namesRepository.getIterator(); iter.hasNext();) {
			String name = (String) iter.next();
			System.out.println("Name : " + name);
		}
	}

	public static void main(String[] args) {
		new IteratorPattern().test();
	}
}
