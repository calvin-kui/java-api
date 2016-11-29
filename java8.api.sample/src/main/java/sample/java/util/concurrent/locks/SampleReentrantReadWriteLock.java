package sample.java.util.concurrent.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SampleReentrantReadWriteLock {

	Object data;
	volatile boolean cacheValid;
	ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	void processCachedData() {
	     rwl.readLock().lock();
	     if (!cacheValid) {
	        // Must release read lock before acquiring write lock
	        rwl.readLock().unlock();
	        rwl.writeLock().lock();
	        // Recheck state because another thread might have acquired
	        //   write lock and changed state before we did.
	        if (!cacheValid) {
	          data = "aaa";
	          cacheValid = true;
	        }
	        // Downgrade by acquiring read lock before releasing write lock
	        rwl.readLock().lock();
	        rwl.writeLock().unlock(); // Unlock write, still hold read
	     }

	     use(data);
	     rwl.readLock().unlock();
	   }
	
	void use(Object data) {
		System.out.println(data.toString());
	}
	
	public static void main(String... args) {
		new SampleReentrantReadWriteLock().processCachedData();
	}
}
