package sample.java.util.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class SampleCyclicBarrier {

	static int player_count = 5;
	int min_gate = 1, max_gate = 10;
	int cur_gate = 0;
	
	CyclicBarrier barrier = new CyclicBarrier(player_count, new GateRunnable());
	
	class PlayerRunnable implements Runnable {
		int no;
		PlayerRunnable(int no) {
			this.no = no;
		}
		
		@Override
		public void run() {
			System.out.println("player-"+no+" is playering " + cur_gate + " begin ...");
			try {
				TimeUnit.MILLISECONDS.sleep(2000);
				System.out.println("player-"+no+" is playering " + cur_gate + "finished ...");
				int parti = barrier.await();
				System.out.println("player-"+no+" is playering go again, " + cur_gate + " , " + parti);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	class GateRunnable implements Runnable {
		@Override
		public void run() {
			cur_gate++;
			System.out.println(cur_gate + " open ...");
			openNextGate();
		}
		
	}
	
	static SampleCyclicBarrier scb = new SampleCyclicBarrier();
	
	void openNextGate() {
		if (cur_gate >= max_gate) {
			System.out.println("game over.");
		} else {
			for (int i=0; i<player_count; i++) {
				new Thread(scb.new PlayerRunnable(i)).start();
			}
		}
	}
	
	public static void main(String[] args) {
		scb.openNextGate();
	}

}
