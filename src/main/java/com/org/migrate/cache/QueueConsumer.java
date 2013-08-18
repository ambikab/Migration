package com.org.migrate.cache;

import java.util.ArrayList;
import java.util.List;
import com.org.migrate.model.Data;
import com.org.migrate.repository.DataRepository;
import com.org.migrate.repository.DataRepositoryImpl;


/**
 * Retrieves the data from the queue 
 * and send for further processing.
 * @author ambika_b
 *
 */
public class QueueConsumer implements Runnable{

	private DataRepository dataRepository = new DataRepositoryImpl();

	@Override
	public void run() {
		while (true) {
			int batchSize = 4; //TODO : move to a property file.
			if(DataBlockingQueue.getQueue().size() == batchSize) {
				List<Data> dataStore = new ArrayList<Data>(); 
				DataBlockingQueue.getQueue().drainTo(dataStore, batchSize);
				dataRepository.saveAll(dataStore);
				//TODO : change to logging
				System.out.println("size of the queue data is" + DataBlockingQueue.getQueue().size()); 
			}
		}
	}
}
