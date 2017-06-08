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

@WebServlet("/StandServlet")
public class StandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Stand> stands = new TreeMap<>();

	public StandServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("stands", stands);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String positionName = request.getParameter("position");

		Stand stand = new Stand();
		stand.setName(positionName);
		Stand std = stands.getOrDefault(positionName, new Stand()).addSalary(Integer.parseInt(request.getParameter("salary")));
		stands.put(positionName, std);
		
		doGet(request, response);
	}

}
