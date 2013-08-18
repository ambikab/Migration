package com.org.migrate.repository;

import java.util.List;

import com.org.migrate.model.Data;

/**
 * CRUD operation related to Data
 * @author ambika_b
 *
 */

public interface DataRepository {
	
	public void save (Data data);
	
	public void saveAll(List<Data> dataStore);

}
