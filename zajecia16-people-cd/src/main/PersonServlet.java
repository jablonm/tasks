package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
import javax.servlet.http.HttpSession;

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
		sortComparator.put("imie_desc", Collections.reverseOrder(sortComparator.get("imie")));
		sortComparator.put("nazw_desc", Collections.reverseOrder(sortComparator.get("nazw")));
		sortComparator.put("wiek_desc", Collections.reverseOrder(sortComparator.get("wiek")));

		actionMap = new HashMap<>();
		actionMap.put("add", this::add);
		actionMap.put("delete", this::delete);
		actionMap.put("edit", this::edit);
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

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Person toEdit = data.stream().filter(p-> p.getId()==id).findAny().get();
		toEdit.setAge(Integer.parseInt(request.getParameter("age")));
		toEdit.setName(request.getParameter("name"));
		toEdit.setSecondname(request.getParameter("secondname"));
		forwardToView(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardToView(request, response);
	}

	private void forwardToView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/people.jsp");
		if (request.getParameter("orderBy") == null) {
			request.setAttribute("persons", data);
		} else {

			HttpSession session = request.getSession();
			String lastSortBy = (String) session.getAttribute("person_sort_by");
			if (request.getParameter("orderBy").equals(lastSortBy)) {
				request.setAttribute("persons", data.stream().sorted(sortComparator.get(request.getParameter("orderBy") + "_desc")).collect(Collectors.toList()));
				session.removeAttribute("person_sort_by");
			} else {
				request.setAttribute("persons", data.stream().sorted(sortComparator.get(request.getParameter("orderBy"))).collect(Collectors.toList()));
				session.setAttribute("person_sort_by", request.getParameter("orderBy"));
			}

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
