package com.nagarro.launcher;

import com.nagarro.exception.InvalidInputException;
import com.nagarro.inputOutput.*;
import com.nagarro.watcher.Watcher;

import java.io.IOException;
import java.util.*;

public class Launcher {

	public static void main(String[] args) throws IOException, InvalidInputException, InterruptedException {
		// TODO Auto-generated method stub

		// used to create the object the Watcher Class
		Watcher watch = new Watcher();
		// Starting the watcher thread
		watch.watcherThread.start();
		Thread.sleep(200);

		char choice = 'y';
		InputOutput IO = new InputOutput();
		do {
			IO.Productinput();
			IO.Productoutput();
			System.out.println("Do you want to search More (Y/N) :");
			choice = IO.scan.next().charAt(0);
		} while (choice == 'y' || choice == 'Y');
//		IO.scan.close();
	}

}

