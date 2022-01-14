package app;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientMain {
	private static final String PACKAGENAME = ClientMain.class.getPackageName(); 
    private static final Logger LOGGER = Logger.getLogger(PACKAGENAME);
	public static void main(String[] args) throws SQLException {
		
		Client client = new Client();
		client.getConnected();
		
		boolean result = client.authentification("badra@test.ml", "2119");
		
		if(result) {
			//LOGGER.log(Level.INFO, "Personne trouvée");
			System.out.println("Personne trouvée");
		}
		else {
			//LOGGER.log(Level.INFO, "personne non trouvee" );
			System.out.println("Personne non trouvée");
		}
		
		
		
		int[] table = RandomTable.randomTable(2);
		RandomTable.randomList(2);
		
		RandomTable.view(table);
		RandomTable.view();
		
	}
	

}
