package main.service.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.action.ActionStrategy;
import main.model.Client;
import main.model.valid.ValidatiorResult;
import main.repository.ClientRepository;
import main.service.DomainService;
import main.service.ValidationService;

public class ClientService implements DomainService {

	private ClientRepository repository = new ClientRepository();
	private Map<String, ActionStrategy> actions;

	private ValidationService<Client> validation;

	public ClientService() {
		validation = new ClientValidationService();

		actions = new HashMap<>();
		actions.put("add", this::add);
		actions.put("delete", this::delete);
		actions.put("edit", this::edit);
		actions.put("sort", this::sort);
		actions.put("search", this::search);
		actions.put("reset", this::reset);

//		sortClient = new TreeMap<>();
//		sortClient.put("name", (o1, o2) -> o1.getName().compareTo(o2.getName()));
//		sortClient.put("name_desc", Collections.reverseOrder(sortClient.get("name")));
//		sortClient.put("secondname", (o1, o2) -> o1.getSecondName().compareTo(o2.getSecondName()));
//		sortClient.put("secondname_desc", Collections.reverseOrder(sortClient.get("secondname")));
//		sortClient.put("address", (o1, o2) -> o1.getAddress().compareTo(o2.getAddress()));
//		sortClient.put("address_desc", Collections.reverseOrder(sortClient.get("address")));
//		sortClient.put("tel", (o1, o2) -> o1.getTel() - o2.getTel());
//		sortClient.put("tel_desc", Collections.reverseOrder(sortClient.get("tel")));
//		sortClient.put("city", (o1, o2) -> o1.getCity().compareTo(o2.getCity()));
//		sortClient.put("city_desc", Collections.reverseOrder(sortClient.get("city")));
	}

	public void add(HttpServletRequest request, HttpServletResponse response) {
		Client newClient = new Client(//
				request.getParameter("name"), // 
				request.getParameter("secondname"), //
				request.getParameter("address"), //
				request.getParameter("city"), //
				Integer.parseInt(request.getParameter("tel")));

		//validujesz nie klienta tylko request i walidujesz request parametry i jak wszystko bedzie okej to dopiero w ifie "if success" tworzysz obiekt
		ValidatiorResult validationResult = validation.validate(newClient);

		if (validationResult.isSuccess()) {
			try {
				repository.save(newClient);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("newClientValidationErrors", validationResult);
		}
		try {
			request.setAttribute("clients", repository.getAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			repository.delete(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("clients", repository.getAll());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) {
		Client editedClient = new Client(//
				Integer.parseInt(request.getParameter("id")), //
				request.getParameter("name"), // 
				request.getParameter("secondname"), //
				request.getParameter("address"), //
				request.getParameter("city"), //
				Integer.parseInt(request.getParameter("tel")));
		try {
			repository.edit(editedClient);
			request.setAttribute("clients", repository.getAll());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> filtered;
		try {
			filtered = repository.search(request);
			request.setAttribute("clients", filtered);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("clients", repository.getAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String lastSortBy = (String) session.getAttribute("sort_by");

		if (request.getParameter("orderBy").equals(lastSortBy)) {
			try {
				request.setAttribute("clients", repository.sort(request.getParameter("orderBy"), "desc"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//request.setAttribute("clients", clients.values().stream().sorted(sortClient.get(request.getParameter("orderBy") + "_desc")).collect(Collectors.toList()));
			session.removeAttribute("sort_by");
		} else {
			try {
				request.setAttribute("clients", repository.sort(request.getParameter("orderBy"), "asc"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//request.setAttribute("clients", clients.values().stream().sorted(sortClient.get(request.getParameter("orderBy"))).collect(Collectors.toList()));
			session.setAttribute("sort_by", request.getParameter("orderBy"));
		}
	}

	public Collection<Client> getAll() throws Exception {
		return repository.getAll();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actions.get(request.getParameter("action")).execute(request, response);
	}

	@Override
	public String getTabName() {
		return "clients";
	}
}
