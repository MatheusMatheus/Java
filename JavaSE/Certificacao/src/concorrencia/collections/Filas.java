package concorrencia.collections;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Filas {
	public static void main(String[] args) {
		blockingDeque();
		blockingQueue();
	}

	static void blockingDeque() {
		try {
			BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
			blockingDeque.offer(91);
			blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
			blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
			blockingDeque.offer(3, 4, TimeUnit.SECONDS);
			System.out.println(blockingDeque);
			System.out.println(blockingDeque.poll());
			System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));
			System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS));
			System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			// Handle interruption
		}
	}

	static void blockingQueue() {
		try {
			BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
			blockingQueue.offer(39);
			blockingQueue.offer(3, 4, TimeUnit.SECONDS);
			System.out.println(blockingQueue.poll());
			System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			// Handle interruption
		}
	}
}
