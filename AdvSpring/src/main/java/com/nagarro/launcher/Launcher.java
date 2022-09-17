package com.nagarro.launcher;



import com.nagarro.watcher.Watcher;

import java.io.IOException;

public class Launcher {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// used to create the object the Watcher Class
		Watcher watch = new Watcher();
		// Starting the watcher thread
		watch.watcherThread.start();
		Thread.sleep(200);

		
	}

}
