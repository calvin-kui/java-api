package sample.java.keywords;

public class SampleVolatile {

	public static volatile int count = 0;
	
	public static void main(String[] args) {
		 new Thread() {
			@Override
			public void run() {
				while(true) {
					System.out.println("Thread 1 count = " + count);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		     
		 }.start();
		 
		 new Thread() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(5000);
						count ++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Thread 2 count = " + count);
				}
			}
		     
		 }.start();
	}
}
