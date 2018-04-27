/*
 * https://www.tutorialspoint.com/design_pattern/proxy_pattern.htm
 * 
 * In proxy pattern, a class represents functionality of another class.In proxy pattern, we create object 
 * having original object to interface its functionality to outer world.
 * 
 * Implementation
 * ---------------
 * We are going to create an Image interface and concrete classes implementing the Image interface. 
 * ProxyImage is a a proxy class to reduce memory footprint of RealImage object loading..
 * 
 */

package com.manas.dp.structural;

public class ProxyPattern {

	public interface Image {
		void display();
	}

	public class RealImage implements Image {

		private String fileName;

		public RealImage(String fileName) {
			this.fileName = fileName;
			loadFromDisk(fileName);
		}

		public void display() {
			System.out.println("Displaying " + fileName);
		}

		private void loadFromDisk(String fileName) {
			System.out.println("Loading " + fileName);
		}
	}

	public class ProxyImage implements Image {

		private RealImage realImage;
		private String fileName;

		public ProxyImage(String fileName) {
			this.fileName = fileName;
		}

		public void display() {
			if (realImage == null) {
				realImage = new RealImage(fileName);
			}
			realImage.display();
		}
	}

	public void test() {
		Image image = new ProxyImage("test_10mb.jpg");
		// image will be loaded from disk
		image.display();
		System.out.println("");
		// image will not be loaded from disk
		image.display();
	}

	public static void main(String args[]) {
		new ProxyPattern().test();
	}

}
