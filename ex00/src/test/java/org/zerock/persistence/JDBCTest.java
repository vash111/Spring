package org.zerock.persistence;


import java.sql.Connection;
import java.sql.DriverManager;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	
	static {
		try {Class.forName("oreacle.jdbc.driver.OrcleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
 }
	public void testConnection() {
		try(Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"book_ex",
				"1234"
				)){
			log.info("con : " +con);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
