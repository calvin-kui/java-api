package sample.java.util;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SamplePriorityQueue {
	
	class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

	static PriorityQueue<Point> pqueue = new PriorityQueue<Point>(10, new Comparator<Point>() {
		@Override
		public int compare(Point p1, Point p2) {
			return p1.x * p1.y - p2.x * p2.y;
		}
		
	});
	
	public static void main(String[] args) {
		pqueue.add(new SamplePriorityQueue().new Point(1, 2));
		pqueue.add(new SamplePriorityQueue().new Point(2, 2));
		pqueue.add(new SamplePriorityQueue().new Point(1, 3));
		pqueue.add(new SamplePriorityQueue().new Point(2, 3));
		pqueue.add(new SamplePriorityQueue().new Point(1, 5));
		
		Point p;
		while((p = pqueue.poll()) != null) {
			System.out.println(p.x * p.y);
		}
	}

}
