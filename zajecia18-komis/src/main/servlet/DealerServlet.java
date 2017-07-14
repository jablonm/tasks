package main.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.service.DomainService;
import main.service.impl.ClientService;

@WebServlet("/DealerServlet")
public class DealerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, DomainService> domains;

	private ClientService clientService;

	@Override
	public void init() throws ServletException {
		clientService = new ClientService();
		//..
		domains = new HashMap<>();
		domains.put("clients", clientService);
		//..
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/index.jsp");
		try {
			request.setAttribute("clients", clientService.getAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//domain & action
		//Dispatcher -> przekierowywanie (Front-Controller)
		domains.get(request.getParameter("domain")).executeWithTab(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/index.jsp");
		rd.forward(request, response);
	}

}
