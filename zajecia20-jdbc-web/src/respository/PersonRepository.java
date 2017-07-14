package respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Person;

public class PersonRepository {

	public Person save(Person person) throws Exception {
		Connection connection = getConnection();
		PreparedStatement insert = connection.prepareStatement("insert into customer(name, surname, age) values (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
		insert.setString(1, person.getName());
		insert.setString(2, person.getSurname());
		insert.setInt(3, person.getAge());
		insert.execute();
		return getPersonWithId(person, connection, insert);
	}

	private Person getPersonWithId(Person person, Connection connection, PreparedStatement insert) throws Exception {
		ResultSet rs = insert.getGeneratedKeys();
		if (rs.next())
			person.setId(rs.getInt(1));
		rs.close();
		insert.close();
		connection.close();
		return person;
	}

	public List<Person> getAll() throws Exception {
		Connection connection = getConnection();
		PreparedStatement select = connection.prepareStatement("select * from customer");
		List<Person> result = new ArrayList<>();
		ResultSet rs = select.executeQuery();
		while (rs.next()) {
			result.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getInt("age")));
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
