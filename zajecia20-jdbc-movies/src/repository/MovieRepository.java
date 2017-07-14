package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Movie;

public class MovieRepository {
	
	private List<Movie> movies;
	
	public Movie save(Movie movie) throws Exception {
		Connection connection = getConnection();
		PreparedStatement insert = connection.prepareStatement("insert into movies(title, year, type) values (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
		insert.setString(1, movie.getTitle());
		insert.setInt(2, movie.getYear());
		insert.setString(3, movie.getGenre());
		insert.execute();
		ResultSet rs = insert.getGeneratedKeys();
		if (rs.next())
			movie.setId(rs.getInt(1));
		rs.close();
		insert.close();
		connection.close();
		return movie;
	}

	public List<Movie> getAll() throws Exception {
		movies = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement select = connection.prepareStatement("select * from movies");
		ResultSet rs = select.executeQuery();
		while (rs.next()) {
			movies.add(new Movie(rs.getInt("id"), rs.getString("title"), rs.getInt("year"), rs.getString("type")));
		}
		select.close();
		connection.close();
		return movies;
	}
	
	private Connection getConnection() throws Exception {
		Connection conn;
		Context init = new InitialContext();
		Context contx = (Context) init.lookup("java:comp/env");
		DataSource dataSource = (DataSource) contx.lookup("jdbc/baza");
		conn = dataSource.getConnection();
		return conn;
	}

}
