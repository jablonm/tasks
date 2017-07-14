package servelet;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/test")
public class JdbcExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn = getConnection();
			response.getWriter().println("polaczenie ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		Connection conn;
		Context init = new InitialContext();
		Context contx = (Context) init.lookup("java:comp/env");
		DataSource dataSource = (DataSource) contx.lookup("jdbc/baza");
		synchronized (dataSource) {
			conn = dataSource.getConnection();
		}
		return conn;
	}

}
