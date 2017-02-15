package com.example.loadimage;

import android.util.Log;

public class MyDaemonThread implements Runnable {

	Thread thrd;

	MyDaemonThread() {

		thrd = new Thread(this);

		thrd.setDaemon(true);

		thrd.start();
	}

	public boolean isDaemon() {

		return thrd.isDaemon();
	}

	@Override
	public void run() {
		try {
			while (true) {
				System.out.print(".");
				Thread.sleep(100);
			}
		} catch (Exception ex) {
			System.out.println("MyDaemon interrupted.");
		}
	}
}

 class DeamonThreadExample{

	public static void main(String args[]) throws Exception {

		MyDaemonThread deamonThread = new MyDaemonThread();
		if (deamonThread.isDaemon()) {
			System.out.println("Daemon thread.");
			Log.e("Daemon thread.Daemon thread.Daemon thread.","Daemon thread.");
		}
		Thread.sleep(10000);
		Log.e("nMain thread endingnMain thread ending","nMain thread ending.");
		System.out.println("nMain thread ending.");
	}
}