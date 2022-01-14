package app;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClientTest {
	Client client = new Client();
	@BeforeEach
	@Test
	void testGetConnected() {
		
		client.getConnected();
		Connection cnx = client.getDatabase();
		assertFalse(cnx == null, "Mauvaise connection");
	}

	@Test
	void testAuthentification() throws SQLException {
		
		String login = "badra@test.ml";
		
		String password = "2119";	
		assertTrue(client.authentification(login, password), "Information incorrecte");
	}
	
	@Test
	void testBadPassword() throws SQLException {
		String login = "badra@test.ml";
		String password = "2118";	
		assertTrue(client.authentification(login, password), "Mot de passe incorrect");
	}
	@Test
	void testUnknowClient() throws SQLException {
		String login = "badra@test.com";
		String password = "2118";	
		assertFalse(client.authentification(login, password), "Client inconnu");
	}
	
	@Test
	void testWithParameterNull() throws SQLException {
		assertTrue(client.authentification(null, null), "Parametres nuls");
	}
	
	@Test
	void testExceptionParameterNull() throws SQLException {
		assertThrows(NullPointerException.class, ()-> {client.authentification(null, null);}, "Erreur : Exception non leve");
	}
	
	

}
