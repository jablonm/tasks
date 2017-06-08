package main;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CitiesServlet")
public class CitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Integer> miasta = new TreeMap<>();

	@Override
	public void init() throws ServletException {
		miasta.put("Polska", 40000000);
		miasta.put("Niemcy", 65000000);
		miasta.put("Wielka Brytania", 35123123);
		miasta.put("Hiszpania", 45023598);
		miasta.put("Francja", 59000000);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("citiesMap", miasta);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/index.jsp");
		rd.forward(request, response);
	}

}
