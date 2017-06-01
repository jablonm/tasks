package persons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Person> data = new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardToView(request, response);
	}


	private void forwardToView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/people.jsp");
		request.setAttribute("persons", data);
		rd.forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person person = new Person(request.getParameter("name"), request.getParameter("secondname"), request.getParameter("age"));
		data.add(person);
		forwardToView(request, response);
	}

}
