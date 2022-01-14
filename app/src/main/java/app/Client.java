package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
	private final Logger LOGGER = Logger.getLogger(Client.class.getName());
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private int pointFidelite;
	private Connection database;
	public Client(int id, String nom, String prenom, String email, String password, int pointFidelite) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.pointFidelite = pointFidelite;
	}
	
	public Client() {
		
	}

	public Connection getDatabase() {
		return database;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPointFidelite() {
		return pointFidelite;
	}

	public void setPointFidelite(int pointFidelite) {
		this.pointFidelite = pointFidelite;
	}
	
	
	public void getConnected(){
		/*
        String username = "root";
        String password = "2119";
        String dbUrl = "jdbc:mysql://localhost:3306/client?serverTimezone=GMT";
        */
		BdConnection.connection();
        this.database = BdConnection.database;
	    
	}
	
	
	public boolean authentification(String login, String password) throws SQLException {
		
		if(login == null || password == null) {
			throw new NullPointerException("parametre nul");
		}
		
		
		
		ResultSet result;
		String dbPassword="";
		String request = "select email, password from client where email=? ";
		try(PreparedStatement statement = database.prepareStatement(request)){
			statement.setString(1, login);
			
			result = statement.executeQuery();
			int compteur = 0;
			while(result.next()) {
				compteur +=1;
				
				dbPassword = result.getString("password");
			}
			if(compteur == 1 && dbPassword.equals(password) ) {
				 return true;
			}
			else if(compteur == 1 && !dbPassword.equals(password)){
					LOGGER.log(Level.INFO, "Mot de passe icorrect");
					return false;
			}
			LOGGER.log(Level.INFO, "client n'existe pas");			
		}finally{
			database.close();
		}
		
		
		return false;
	}
	
	
	
	
	
	
	
}
