package server_battle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderService implements Runnable {
	private final OrderQueue queue;
	private final ExecutorService pool;

	public OrderService(OrderQueue queue, int poolSize) {
		this.queue = queue;
		this.pool = Executors.newFixedThreadPool(poolSize);
	}

	public void run() {
		for (;;) {
			pool.execute(queue.take());
		}
	}
}

