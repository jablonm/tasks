package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Movie;
import repository.MovieRepository;

@WebServlet("/movies")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieRepository repository = new MovieRepository();
		List<Movie> movies = new ArrayList<>();
		try {
			movies = repository.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/movies.jsp");
		request.setAttribute("movies", movies);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Movie movie = new Movie(request.getParameter("title"), Integer.parseInt(request.getParameter("year")), request.getParameter("genre"));
		MovieRepository repository = new MovieRepository();
		try {
			repository.save(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
