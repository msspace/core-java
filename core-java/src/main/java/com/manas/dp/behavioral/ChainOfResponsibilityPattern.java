/*
 * https://www.tutorialspoint.com/design_pattern/chain_of_responsibility_pattern.htm
 *
 * As the name suggests, the chain of responsibility pattern creates a chain of receiver objects 
 * for a request. This pattern decouples sender and receiver of a request based on type of request. 
 * This pattern comes under behavioral patterns. In this pattern, normally each receiver contains 
 * reference to another receiver. If one object cannot handle the request then it passes the same 
 * to the next receiver and so on.
 * 
 * Implementation
 * ---------------
 * We have created an abstract class AbstractLogger with a level of logging. Then we have created 
 * three types of loggers extending the AbstractLogger. Each logger checks the level of message 
 * to its level and print accordingly otherwise does not print and pass the message to its next logger.
 */

package com.manas.dp.behavioral;

import java.util.Date;

public class ChainOfResponsibilityPattern {
	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;

	public abstract class AbstractLogger {

		protected int level;

		// next element in chain or responsibility
		protected AbstractLogger nextLogger;

		public void setNextLogger(AbstractLogger nextLogger) {
			this.nextLogger = nextLogger;
		}

		public void logMessage(int level, String message) {
			if (this.level <= level) {
				write(message);
			}
			if (nextLogger != null) {
				nextLogger.logMessage(level, message);
			}
		}

		abstract protected void write(String message);

	}

	public class ConsoleLogger extends AbstractLogger {

		public ConsoleLogger(int level) {
			this.level = level;
		}

		@Override
		protected void write(String message) {
			System.out.println("Standard Console::Logger: " + message);
		}
	}

	public class ErrorLogger extends AbstractLogger {

		public ErrorLogger(int level) {
			this.level = level;
		}

		@Override
		protected void write(String message) {
			System.out.println("Error Console::Logger: " + message);
		}
	}

	public class FileLogger extends AbstractLogger {

		public FileLogger(int level) {
			this.level = level;
		}

		@Override
		protected void write(String message) {
			System.out.println("File::Logger: " + message);
		}
	}

	private AbstractLogger getChainOfLoggers() {
		AbstractLogger errorLogger = new ErrorLogger(ChainOfResponsibilityPattern.ERROR);
		AbstractLogger fileLogger = new FileLogger(ChainOfResponsibilityPattern.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(ChainOfResponsibilityPattern.INFO);
		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
		return errorLogger;
	}

	public void test() {
		AbstractLogger loggerChain = getChainOfLoggers();
		loggerChain.logMessage(ChainOfResponsibilityPattern.INFO, "This is an information.");
		loggerChain.logMessage(ChainOfResponsibilityPattern.DEBUG, "This is an debug level information.");
		loggerChain.logMessage(ChainOfResponsibilityPattern.ERROR, "This is an error information.");
	}

	public static void main(String[] args) {
		new ChainOfResponsibilityPattern().test();
	}
}
