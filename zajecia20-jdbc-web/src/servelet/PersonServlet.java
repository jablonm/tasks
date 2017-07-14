package servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;
import respository.PersonRepository;

@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PersonRepository personRepository = new PersonRepository();
			List<Person> people = personRepository.getAll();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.println("<table><tr><td>Id</td><td>imie</td><td>nazwisko</td><td>wiek</td></tr>");
			for (Person p : people) {
				out.println("<tr><td>" + p.getId() + "</td><td>" + p.getName() + "</td><td>" + p.getSurname() + "</td><td>" + p.getAge() + "</td></tr>");
			}
			out.print("</table>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
