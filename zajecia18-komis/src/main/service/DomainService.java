package main.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DomainService {
	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	String getTabName();
	
	default void executeWithTab(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("activeTab", getTabName());
		execute(request, response);
	}
	 
}
