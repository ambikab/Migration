package com.org.migrate.cache;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import com.org.migrate.model.Data;

/**
 * Cache that stores the Data received, 
 * from the request.
 * @author ambika_b
 *
 */

public class DataBlockingQueue {
	
	private static final BlockingQueue<Data> queue = new ArrayBlockingQueue<Data>(20);
	
	public static BlockingQueue<Data> getQueue() {
		return queue;
	}
}
