package com.example.springjdbcstudy.connection;

import static com.example.springjdbcstudy.connection.ConnectionConst.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBConnectionUtil {
	public static Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			log.info("get connection={}, class={}", connection, connection.getClass());

			return connection;
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}
}