
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

	private Map<String, Comparator<Person>> sortComparator;
	private Map<String, PeopleActionStrategy> actionMap;

	@Override
	public void init() throws ServletException {
		data.add(new Person("Roman", "Giertych", 40));
		data.add(new Person("Andrzej", "Golota", 50));

		sortComparator = new TreeMap<>();
		sortComparator.put("imie", (o1, o2) -> o1.getName().compareTo(o2.getName()));
		sortComparator.put("nazw", (o1, o2) -> o1.getSecondname().compareTo(o2.getSecondname()));
		sortComparator.put("wiek", (o1, o2) -> o1.getAge() - o2.getAge());

		actionMap = new HashMap<>();
		actionMap.put("add", this::add);
		actionMap.put("delete", this::delete);
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		data.removeIf(p -> p.getId() == id);
		forwardToView(request, response);
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Person person = new Person(request.getParameter("name"), request.getParameter("secondname"), Integer.parseInt(request.getParameter("age")));
			data.add(person);
			forwardToView(request, response);
		} catch (Exception e) {
			showException(request, response, e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardToView(request, response);
	}

	private void forwardToView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/people.jsp");
		if (request.getParameter("orderBy") == null) {
			request.setAttribute("persons", data);
		} else {
			request.setAttribute("persons", data.stream().sorted(sortComparator.get(request.getParameter("orderBy"))).collect(Collectors.toList()));
		}
		rd.forward(request, response);
	}

	private void showException(HttpServletRequest request, HttpServletResponse response, Exception e) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/people.jsp");
		request.setAttribute("onError", e);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionMap.get(request.getParameter("action")).execute(request, response);
	}

}
