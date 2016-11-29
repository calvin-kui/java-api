package sample.java.util.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SampleCountDownLatch {

	public static void main(String...strings) throws InterruptedException {
		int n = 10;
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(n);

		for (int i = 0; i < n; ++i) // create and start threads
			new Thread(new Worker(startSignal, doneSignal, i)).start();

		System.out.println("main prepared be ready ..."); // don't let run yet
		startSignal.countDown(); // let all threads proceed
		System.out.println("main prepared be ready ok");
		doneSignal.await(); // wait for all to finish
	}
}

class Worker implements Runnable {
	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;
	private int no;

	Worker(CountDownLatch startSignal, CountDownLatch doneSignal, int no) {
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
		this.no = no;
	}

	public void run() {
		try {
			startSignal.await();
			doWork();
			doneSignal.countDown();
		} catch (InterruptedException ex) {
		} // return;
	}

	void doWork() {
		System.out.println("work " + no + " running...");
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}