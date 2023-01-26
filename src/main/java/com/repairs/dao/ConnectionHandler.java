package com.repairs.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionHandler {
	
	static Logger log = LoggerFactory.getLogger(ConnectionHandler.class);

	static Connection connection;
	
	private ConnectionHandler() {}

	public static Connection getConnection() {
		try {
			Properties prop = new Properties();
			InputStream is = ConnectionHandler.class.getClassLoader().getResourceAsStream("connection.properties");
			prop.load(is);
			Class.forName(prop.getProperty("driver"));
			connection = DriverManager.getConnection(prop.getProperty("connection-url"), prop.getProperty("user"),
					prop.getProperty("password"));
		} catch (Exception e) {
			log.debug("ConnectionHandler : {0} " , e);
		}
		return connection;
	}
}
