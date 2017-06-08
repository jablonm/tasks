package service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.action.ActionStrategy;
import main.model.Client;
import service.DomainService;

public class ClientService implements DomainService {

	private Map<Integer, Client> clients;
	private Map<String, ActionStrategy> actions;
	private Map<String, Comparator<Client>> sortClient;

	public ClientService() {
		clients = new HashMap<>();
		Arrays.asList(new Client("Andrzej", "Fsdas", "Soliñska", "233213232", "Warszawa"), //
				new Client("Marek", "Cfaas", "D¹browskiego", "259874652", "Poznañ"), //
				new Client("Tomasz", "Padsasd", "Fabryczna", "123587469", "£ódz"), //
				new Client("Wojciech", "Ladsad", "Wroc³awska", "5846978521", "Wroc³aw"), //
				new Client("Iwona", "Ldasasd", "Spizowa", "1256985362", "Kraków")//
		).forEach(c -> clients.put(c.getId(), c));
		actions = new HashMap<>();
		actions.put("add", this::add);
		actions.put("delete", this::delete);
		actions.put("edit", this::edit);
		actions.put("sort", this::sort);
		
		sortClient.put("imie", (o1, o2) -> o1.getName().compareTo(o2.getName()));
		sortClient.put("imie_desc", Collections.reverseOrder(sortClient.get("imie")));
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	public void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String lastSortBy = (String) session.getAttribute("sortBy");
		
		if (request.getParameter("orderBy").equals(lastSortBy)) {
			request.setAttribute("clients", clients.values().stream().sorted(sortClient.get(request.getParameter("orderBy") + "_desc")).collect(Collectors.toList()));
			session.removeAttribute("sort_by");
		} else {
			request.setAttribute("clients", clients.values().stream().sorted(sortClient.get(request.getParameter("orderBy"))).collect(Collectors.toList()));
			session.setAttribute("sort_by", request.getParameter("orderBy"));
		}
	}

	public Collection<Client> getAll() {
		return clients.values();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actions.get(request.getParameter("action")).execute(request, response);
	}
}
