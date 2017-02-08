package org.testng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DbConnectionAndRetrieveData {

	Connection conn = null;

	static String data;

	@Test
	public void retrieveData() throws SQLException {

		try {
			System.setProperty("java.library.path", "sqljdbc_auth.dll");

			// mysql database connectivity
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
					.newInstance();

			conn = DriverManager
					.getConnection("jdbc:sqlserver://localhost;database=Testing;integratedSecurity=true;",
							"sa", "root");
			
			Reporter.log("Database connection established", true);

		} catch (Exception e) {
			System.out.println("Error message: " +e.getMessage());

		}

		try {
			Statement st = conn.createStatement();
			String sql = "select * from TestingTable";

			ResultSet rs = st.executeQuery(sql);
			
			ResultSetMetaData md = rs.getMetaData();
			int colcount = md.getColumnCount();
			Reporter.log("Sql Query : " + sql, true);
			Reporter.log("Number of Column : " + colcount, true);
			Reporter.log("Columnnames...........", true);
			for (int j = 1; j <= colcount; j++) {
				String col_name = md.getColumnName(j);
				Reporter.log(col_name, true);
			}// for

			if (rs.next()) {
				do {
					for (int i = 1; i <= colcount; i++) {
						data = rs.getString(i);
						Reporter.log(data, true);
					}// for
					Reporter.log("....................................................",
							true);
				} while (rs.next());// do while
			}
		}// try
		catch (SQLException s) {
			System.out.println("SQL statement is not executed!:"
					+ s.getMessage());

		}// catch

		finally {
			if (conn != null && !conn.isClosed()) {
				Reporter.log("Closing Database Connection", true);
				conn.close();
			}

		}
	}

}



