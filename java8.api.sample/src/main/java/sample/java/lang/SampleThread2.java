package sample.java.lang;

import java.util.concurrent.TimeUnit;

public class SampleThread2 {

	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread(new ADaemon());

		t.setDaemon(true);

		t.start();
		
//		TimeUnit.SECONDS.sleep(1);

	}
}

class ADaemon implements Runnable {

	public void run() {

		try {

			System.out.println("start ADaemon...");

			TimeUnit.SECONDS.sleep(1);

		} catch (InterruptedException e) {

			System.out.println("Exiting via InterruptedException");

		} finally {

			System.out.println("This shoud be always run ?");

		}

	}

}
