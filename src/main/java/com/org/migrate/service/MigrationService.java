package com.org.migrate.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.org.migrate.cache.DataBlockingQueue;
import com.org.migrate.cache.QueueConsumer;
import com.org.migrate.model.Data;

/**
 * Data migration end points
 * @author ambika_b
 *
 */
@Path("/migrate/data")
public class MigrationService {

	private static final ExecutorService executor = Executors.newFixedThreadPool(10);

	static {
		executor.submit(new QueueConsumer());
	}
	
	/**
	 * Handles the POST request.
	 * @param data
	 * @return
	 */
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(final Data data) {
		final Data store = new Data();
		store.setContents("<xml>Contents goes here</xml>");
		executor.submit(new Runnable() {
			@Override
			public void run() {
				store.setId(Thread.currentThread().getId());
				DataBlockingQueue.getQueue().add(store);
			}
		});
		return Response.status(201).entity("data saved!!").build();
	}

}