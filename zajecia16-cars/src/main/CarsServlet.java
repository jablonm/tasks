package main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CarsServlet")
public class CarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, ActionStrategy> actionMap;

	@Override
	public void init() throws ServletException {
		
		actionMap = new HashMap<String, ActionStrategy>();
		actionMap.put("add", this::add);
		actionMap.put("delete", this::delete);
		actionMap.put("reset", this::reset);
		actionMap.put("filter", this::filter);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionMap.get(request.getParameter("action")).execute(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardToView(request, response);
	}

	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardToView(request, response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardToView(request, response);
	}
	
	protected void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardToView(request, response);
	}
	
	protected void filter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardToView(request, response);
	}
	
	
	private void forwardToView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/index.jsp");
		rd.forward(request, response);
	}

}
