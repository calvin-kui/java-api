package sample.java.keywords;

public class SampleSynchronized {

	public synchronized void test1() {
		int i = 5;
		while (i-- > 0) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
			}
		}
	}
	
	public synchronized void test11() {
		int i = 5;
		while (i-- > 0) {
			System.out.println(Thread.currentThread().getName() + " : instance " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
			}
		}
	}

	public static synchronized void test2() {
		int i = 5;
		while (i-- > 0) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
			}
		}
	}
	
	public static synchronized void test21() {
		int i = 5;
		while (i-- > 0) {
			System.out.println(Thread.currentThread().getName() + " : static " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
			}
		}
	}

	public static void main(String[] args) {
		final SampleSynchronized myt2 = new SampleSynchronized();
		Thread test1 = new Thread(new Runnable() {
			public void run() {
				myt2.test1();
			}
		}, "instance-test1");
		Thread test11 = new Thread(new Runnable() {
			public void run() {
				myt2.test11();
			}
		}, "instance-test2");
		Thread test2 = new Thread(new Runnable() {
			public void run() {
				SampleSynchronized.test2();
			}
		}, "static-test1");
		Thread test21 = new Thread(new Runnable() {
			public void run() {
				SampleSynchronized.test21();
			}
		}, "static-test2");

		test1.start();
		test11.start();
		test2.start();
		test21.start();
		// TestRunnable tr=new TestRunnable();
		// Thread test3=new Thread(tr);
		// test3.start();
	}
}
