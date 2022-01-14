package app;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class RandomTable {
	static SecureRandom sRand = new SecureRandom();
	static ArrayList<Integer> array = new ArrayList<Integer>();
	static final Logger LOGGER = Logger.getLogger(RandomTable.class.getName());
	
	private RandomTable() {
		throw new IllegalStateException("Classe utilitaire");
	}
	
	
	public static int[] randomTable(final int size) {
		
		int[] table = new int[size];
		for(int i = 0; i < table.length; i++) {
			table[i] = sRand.nextInt();
		}
		return table;
	}
	
	public static void randomList(final int size) {
		for(int i = 0; i < size; i++) {
			array.add(sRand.nextInt());
		}
	}
	
	
	public static void view() {
		for(int i = 0; i < array.size(); i++) {
			LOGGER.log(Level.INFO, "{0}", array.get(i));
		}
	}
	public static void view(int[] table) {
		for(int i = 0; i < table.length; i++) {
			LOGGER.log(Level.INFO, "{0}", array.get(i));
		}
	}
	
	
}
