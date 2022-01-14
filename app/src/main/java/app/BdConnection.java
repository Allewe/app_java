package app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BdConnection {
	
	private BdConnection() {
		throw new IllegalStateException("Classe utilitaire");
	}
	static final Logger LOGGER = Logger.getLogger(BdConnection.class.getName());
    static Connection database;
    public static void connection(){
        String username = "root";
        String password = "2119";
        String dbUrl = "jdbc:mysql://localhost:3306/client?serverTimezone=GMT";
       try {
                database = DriverManager.getConnection(dbUrl,username, password );
                LOGGER.log(Level.INFO,"Connexion Reussie");
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
    }

}