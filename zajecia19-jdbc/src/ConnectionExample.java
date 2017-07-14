import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionExample {
	public static void main(String[] args) throws Exception {
		
		//POLA POLACZEN 50 polaczen,
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-example", "root", "1234");
		System.out.println("Polaczono");

		Statement stmt = conn.createStatement();

		ResultSet results = stmt.executeQuery("select * from customer");
		while (results.next()) {
			System.out.println(results.getString("name") + " " + results.getString("surname") + " " + results.getInt("age") + " " + results.getString("id"));
		}
		results.close();

		PreparedStatement insert = conn.prepareStatement("insert into customer (name, surname, age) values (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

		insert.setString(1, "Waldek");
		insert.setString(2, "Pietrzak");
		insert.setInt(3, 29);

		insert.execute();

		ResultSet keys = insert.getGeneratedKeys();
		if (keys.next()) {
			System.out.println(keys.getString(1));
		}
		keys.close();

		insert.close();
		stmt.close();
		conn.close();
		
		//sqlInjection
		//LOGIN = DUPA
		//PASSWORD = ' or 1==1 or password = '
		//select * from secretUser where login = 'LOGIN' and passowrd = 'PASSWORD'
	}
}
