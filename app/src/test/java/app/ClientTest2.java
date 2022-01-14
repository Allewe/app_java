package app;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientTest2 {
	static Client client = null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 client = new Client();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

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
