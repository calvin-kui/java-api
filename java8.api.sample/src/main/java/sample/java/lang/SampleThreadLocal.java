package sample.java.lang;

public class SampleThreadLocal {

	// 创建一个Integer型的线程本地变量
	private static final ThreadLocal<Integer> THREAD_LOCAL = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[5];
		for (int j = 0; j < 5; j++) {
			threads[j] = new Thread(new Runnable() {
				@Override
				public void run() {
					// 获取当前线程的本地变量，然后累加5次
					int num = THREAD_LOCAL.get();
					for (int i = 0; i < 5; i++) {
						num++;
					}
					// 重新设置累加后的本地变量
					THREAD_LOCAL.set(num);
					System.out.println(Thread.currentThread().getName() + " : " + THREAD_LOCAL.get());

				}
			}, "Thread-" + j);
		}

		for (Thread thread : threads) {
			thread.start();
		}
	}

}
