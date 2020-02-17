package theMainPakage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Gestion {
	
	/**
	 * The main gestion method where we can create a new hotel and handle it.
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		Hotel h1 = new Hotel("HOTEL CDA JAVA",false,Hotel.chambreMaker(new ArrayList<Chambre>()));
		h1.setOuvert(true);
		Hotel h2 = new Hotel("HOTE PYTHON",false,Hotel.chambreMaker(new ArrayList<Chambre>()));
		h2.gestionDeHotel();
		
	}
}
