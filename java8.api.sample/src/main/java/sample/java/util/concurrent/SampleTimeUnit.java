package sample.java.util.concurrent;

import java.util.concurrent.TimeUnit;

public class SampleTimeUnit {

	class subThread extends Thread {

		@Override
		public void run() {
			while(true) {
				System.out.println(" sub Thread running");
				try {
					TimeUnit.MILLISECONDS.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String...args) {
		
		System.out.println(TimeUnit.MILLISECONDS.convert(10L, TimeUnit.MINUTES));
		
		SampleTimeUnit stu = new SampleTimeUnit();
		Thread t = stu.new subThread();
		t.start();
		
		try {
//			TimeUnit.MILLISECONDS.timedJoin(t, 3000);
			
			synchronized(stu) {
				TimeUnit.MILLISECONDS.timedWait(stu, 3000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main thread exit.");
	}
}
