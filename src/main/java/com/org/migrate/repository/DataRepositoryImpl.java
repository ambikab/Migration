package com.org.migrate.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.org.migrate.util.DBUtil;
import com.org.migrate.model.Data;

/**
 * 
 * @author ambika_b
 *
 */
public class DataRepositoryImpl implements DataRepository {

	Connection dbConnection;

	public DataRepositoryImpl() {
		dbConnection = DBUtil.getConnection();
	}

	@Override
	public void save(Data data) {
		System.out.println("Data saved" + data.toString());
		try {
			PreparedStatement preparedStatement = dbConnection.prepareStatement("insert into data_store(id,contents) values (?, ? )");
			preparedStatement.setLong(1, data.getId());
			preparedStatement.setString(2, data.getContents());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveAll(List<Data> dataStore) {
		try {
			Statement statement = dbConnection.createStatement();
			for (Data data : dataStore) {
				String query = "insert into data_store (id, content) values(" + data.getId() + " , '" + data.getContents() + "')";
				statement.addBatch(query);
			}
			statement.executeBatch();
			System.out.println("Data saved in the database!!");
		} catch (SQLException e) {
			System.out.println("Exception occured while persisting into the database!");
			e.printStackTrace();
		}
		
	}

}
