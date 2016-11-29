package sample.java.util.concurrent;

public class SampleInterrupt {
	
	class NoBlockThread extends Thread {	
		public void run() {
			while (true) {
				if (Thread.interrupted()) {
					System.out.println("Someone interrupted me.");
				} else {
					System.out.println("Going...");
				}
				long now = System.currentTimeMillis();
				while (System.currentTimeMillis() - now < 1000) {
					// 为了避免Thread.sleep()而需要捕获InterruptedException而带来的理解上的困惑,
					// 此处用这种方法空转1秒
				}
			}
		}
	}
	
	class BlockThread extends Thread {
		private Thread parent = null;
		BlockThread(Thread parent) {
			this.parent = parent;
		}
		
		public void run() {
			while (true) {
				if (Thread.interrupted()) {
					System.out.println("Someone interrupted me.");
				} else {
					System.out.println("Going...");
				}
				long now = System.currentTimeMillis();
				while (System.currentTimeMillis() - now < 1000) {
					// 为了避免Thread.sleep()而需要捕获InterruptedException而带来的理解上的困惑,
					// 此处用这种方法空转1秒
				}
				this.parent.interrupt();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
//		NoBlockThread nt = new SampleInterrupt().new NoBlockThread();
//		nt.start();
//		
//		Thread.sleep(3000);
//		nt.interrupt();
		
		
		BlockThread bt = new SampleInterrupt().new BlockThread(Thread.currentThread());
		bt.start();
		
		try {
			bt.join();
		} catch (Exception e) {
			System.out.println("Parent thread will die..." + Thread.currentThread().isInterrupted());  
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("Parent thread interrupted. " + Thread.currentThread().isInterrupted());
			}
		}
	}
}
