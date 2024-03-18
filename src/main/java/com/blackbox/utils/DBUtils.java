package com.blackbox.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

	private static final Logger logger = LogManager.getLogger(DBUtils.class);

	private static final String URL = ConfigManager.getProperty("db_URL");

	private static final String USER = ConfigManager.getProperty("db_username");

	private static final String PASSWORD = ConfigManager.getProperty("db_password");

	static {
		try {
			Class.forName("org.postgresql.Driver");
			logger.info("PostgreSql JDBC Driver loaded");
		}
		catch (ClassNotFoundException e) {
			logger.error("PostgreSql JDBC Driver not found");
		}
	}

	public static Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		}
		catch (SQLException e) {
			logger.error("Database connection error");
			throw new SQLException();
		}
	}

	public static List<Map<String, Object>> executeQueryForMapList(String query) {
		List<Map<String, Object>> resultList = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet rs = preparedStatement.executeQuery()) {
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			while (rs.next()) {
				Map<String, Object> rowMap = new HashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					rowMap.put(metaData.getColumnName(i), rs.getObject(i));
				}
				resultList.add(rowMap);
			}

		}
		catch (SQLException e) {
			logger.error("SQL Exception during executeQueryForMapList method");
		}
		return resultList;
	}

	public static <T> List<T> executeQuery(String query, RowMapper<T> rowMapper) {
		List<T> results = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet rs = preparedStatement.executeQuery()) {
			while (rs.next()) {
				results.add(rowMapper.mapRow(rs));
			}
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return results;
	}

}
