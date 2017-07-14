package main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import main.model.Client;

public class ClientRepository {

	public Client save(Client client) throws Exception {
		Connection connection = getConnection();
		PreparedStatement insert = connection.prepareStatement("insert into dealer.clients(name, secondname, address, city, tel) values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
		insert.setString(1, client.getName());
		insert.setString(2, client.getSecondName());
		insert.setString(3, client.getAddress());
		insert.setString(4, client.getCity());
		insert.setInt(5, client.getTel());
		insert.execute();
		return getPersonWithId(client, connection, insert);
	}

	private Client getPersonWithId(Client client, Connection connection, PreparedStatement insert) throws Exception {
		ResultSet rs = insert.getGeneratedKeys();
		if (rs.next())
			client.setId(rs.getInt(1));
		rs.close();
		insert.close();
		connection.close();
		return client;
	}

	public void edit(Client client) throws Exception {
		Connection connection = getConnection();
		PreparedStatement update = connection.prepareStatement("update dealer.clients set name=?, secondname=?, address=?, city=?, tel=? where id=?");
		update.setString(1, client.getName());
		update.setString(2, client.getSecondName());
		update.setString(3, client.getAddress());
		update.setString(4, client.getCity());
		update.setInt(5, client.getTel());
		update.setInt(6, client.getId());
		update.execute();
		update.close();
		connection.close();
	}
	
	public void delete(Integer id) throws Exception {
		Connection connection = getConnection();
		PreparedStatement delete = connection.prepareStatement("delete from dealer.clients where id=?");
		delete.setInt(1, id);
		delete.execute();
		delete.close();
		connection.close();
	}
	
	public List<Client> sort(String by, String order) throws Exception {
		System.out.println(by + " " + order);
		Connection connection = getConnection();

		final String SQL = "select * from dealer.clients order by %s";
		String sql = String.format(SQL, by + " " + order);
		PreparedStatement sort = connection.prepareStatement(sql);
		
		List<Client> result = new ArrayList<>();
		ResultSet rs = sort.executeQuery();
		while (rs.next()) {
			result.add(new Client(//
					rs.getInt("id"),//
					rs.getString("name"),//
					rs.getString("secondname"),//
					rs.getString("address"),//
					rs.getString("city"),//
					rs.getInt("tel")));
		}
		rs.close();
		sort.close();
		connection.close();
		return result;
	}
	
	public List<Client> search(HttpServletRequest request) throws Exception {
		Connection connection = getConnection();
		PreparedStatement search = connection.prepareStatement("select * from dealer.clients where //"
				+ "name like '%?%' and //"
				+ "secondname like '%?%' and //"
				+ "address like '%?%' and //"
				+ "city like '%?%' and//"
				+ "tel like '%?%'");
		
		List<Client> result = new ArrayList<>();
		if (!request.getParameter("name").isEmpty()) {
			search.setString(1, request.getParameter("name"));
		} else {
			search.setString(1, null);
		}
		if (!request.getParameter("secondname").isEmpty()) {
			search.setString(1, request.getParameter("secondname"));
		} else {
			search.setString(1, null);
		}
		if (!request.getParameter("address").isEmpty()) {
			search.setString(1, request.getParameter("address"));
		} else {
			search.setString(1, null);
		}
		if (!request.getParameter("city").isEmpty()) {
			search.setString(1, request.getParameter("city"));
		} else {
			search.setString(1, null);
		}
		if (!request.getParameter("tel").isEmpty()) {
			search.setInt(1, Integer.parseInt(request.getParameter("tel")));
		} else {
			search.setString(1, null);
		}
		ResultSet rs = search.executeQuery();
		while (rs.next()) {
			result.add(new Client(//
					rs.getInt("id"),//
					rs.getString("name"),//
					rs.getString("secondname"),//
					rs.getString("address"),//
					rs.getString("city"),//
					rs.getInt("tel")));
		}
		rs.close();
		search.close();
		connection.close();
		return result;
	}
	
	public List<Client> getAll() throws Exception {
		Connection connection = getConnection();
		PreparedStatement select = connection.prepareStatement("select * from dealer.clients");
		List<Client> result = new ArrayList<>();
		ResultSet rs = select.executeQuery();
		while (rs.next()) {
			result.add(new Client(//
					rs.getInt("id"),//
					rs.getString("name"),//
					rs.getString("secondname"),//
					rs.getString("address"),//
					rs.getString("city"),//
					rs.getInt("tel")));
		}
		rs.close();
		select.close();
		connection.close();
		return result;
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
