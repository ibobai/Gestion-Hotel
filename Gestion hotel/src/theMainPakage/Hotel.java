package theMainPakage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Hotel {
	
	/**
	 * A class to generate a hotel and all it's methods.
	 */
	private boolean ouvert = false;
	private String name = "Sans nom pour l'instaint!";
	private ArrayList<Chambre> chambres = new ArrayList<Chambre>();
	
	public Hotel(String name,boolean ouvert,ArrayList<Chambre> chambres) {
		super();
		this.ouvert = ouvert;
		this.name = name;
		this.chambres = chambres;
	}
	public Hotel() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public ArrayList<Chambre> getChambres() {
		return this.chambres;
	}
	public void setChambres(ArrayList<Chambre> chambres) {
		this.chambres = chambres;
	}



	public boolean isOuvert() {
		return ouvert;
	}

	public void setOuvert(boolean ouvert) {
		this.ouvert = ouvert;
	}
	
	
	public ArrayList<Chambre> chambresVides() {
		/**
		 * A method to get the non reserved rooms
		 */
		ArrayList<Chambre> chambreNonRes = new ArrayList<Chambre>();
		for(Chambre chambre : this.getChambres()) {
			if(!chambre.isReserve()) {
				chambreNonRes.add(chambre);
			}
		}
		return chambreNonRes;
	}
	
	public ArrayList<Chambre> chambresNonVides() {
		/**
		 * A method to get the non reserved rooms
		 */
		ArrayList<Chambre> chambreRes = new ArrayList<Chambre>();
		for(Chambre chambre : this.getChambres()) {
			if(chambre.isReserve()) {
				chambreRes.add(chambre);
			}
		}
		return chambreRes;
	}
	
	
	//pour crée 20 chambres aléatoire dans un hôtel.
		public static ArrayList<Chambre>chambreMaker(ArrayList<Chambre> chambres) {
			
			/**
			 * A Methode that generates the 20 room with diffrents state
			 * @param chambres an empty list fo rooms
			 */
				//random index to get the room state
				Random rand = new Random();
				int ndx;
				
				// room state list
				ArrayList<Boolean> etatChambre = new ArrayList<Boolean>();
				etatChambre.add(true);etatChambre.add(false);
				
				//to generate random rooms
				String chambre = "ChambreNumero";
				for (int i = 0; i < 20; i++) {
					 ndx = rand.nextInt(2);
					chambres.add(new Chambre(chambre+(i+1),i+1,etatChambre.get(ndx)));
				}
				return chambres;
		}
	
	
	

		
	
		
		private int adminLogin() {
		/**
		 * A method for the admin login !
		 */
		
		//if the user wanted to liberate a room
	
			//pour les admins, le system de mdps est different! pour la sécurité.
			String admin ="";
			String mdps="" ;
			int foisRestant = 3;
			Scanner scan3 = new Scanner(System.in);
			
			while (!(admin.equals("Admin1") || foisRestant <= 0 )){
				System.out.print("Entrez le nom d'Admin: ");
				 admin = scan3.nextLine();
				 foisRestant--;
			}
			
			// if the user has correctelly entered the login name!
			if(admin.equals("Admin1")) {
				foisRestant = 3;
				do {
				    System.out.print("Entrez le mdps: ");
				    while (!scan3.hasNext()) {
				        System.out.println("Entrez le mdps: ");
				        scan3.next(); // this is important!
				       
				    }
				    mdps = scan3.nextLine();
				    foisRestant--;
				} while (!(mdps.equals("mdpsibobai") || foisRestant <= 0 ));
				
			}
			int res = mdps.equals("mdpsibobai")? 1: 0;
			return res;
			
	}
		
	
	private void liberateAroom() {
		/**
		 * A method to liberate a room
		 */
		//if the user has correctelly entered the name and the password
		if(this.adminLogin() == 1) {
			System.out.println("\n------------------\n| Bonjour Ibobai |\n------------------");
			for(Chambre chambre : this.getChambres()) {
				if(chambre.equals(this.chambresNonVides().get(this.chambresNonVides().size()-1))) {
					chambre.setReserve(false);
					System.err.println("--------------------------------------------------\nVous avez bien libérée cette chambre:\n--------------------------------------------------\n");
					System.out.println(chambre.toString());
					break;
				}
			}
		}else {
			System.err.println("----------------------------\nVous n'êtes pas un admin!  |\n----------------------------");
		}
		
	}
	
	private int userLoing() {
		
		/**
		 * A method for the users login!
		 */
		
		Scanner scan2 = new Scanner(System.in);
		System.out.println("\nPour vous rappler, pour quitter il faut entrer q ou quit pour quitter \navant de commencer de saisir de mot de passe.\n"+
				
				"--------------------------------------------------------------------------------------");
		boolean correct = true; //To check the confirmation of the password
		
		
		//to get the user's name
		String nom;
		do {
		    System.out.print("Entrez un nom d'une longueur qui > 4: ");
		    nom = scan2.nextLine();
		} while ((nom.length() < 4) && !(nom.equalsIgnoreCase("q")) && !(nom.equalsIgnoreCase("quit")));
		
		if(nom.equalsIgnoreCase("q") || nom.equalsIgnoreCase("quit")) {
			System.out.println("\n-----------------------------------------------------\nVous avez été dérigé vers le meun principal!\n-----------------------------------------------------");
			correct = true;
			
		} else {
			
			
			//for the password and the confirmation
			
			while(correct) {
				int mdp;
				do {
				    System.out.print("Entrez un mot  de passe qui contient au moins 6 chiffres SVP: ");
				    while (!scan2.hasNextInt()) {
					    System.err.print("Entrez un mot  de passe qui contient au moins 6 chiffres SVP: ");
				        scan2.next();
				    }
				    mdp = scan2.nextInt();
				} while (Integer.toString(mdp).length() < 6);
				
				int mdp2;
				do {
				    System.out.print("Confirmez vôtre mot de passe SVP : ");
				    while (!scan2.hasNextInt()) {
					    System.err.print("Confirmez vôtre mot de passe : ");
				        scan2.next(); 
				    }
				    mdp2 = scan2.nextInt();
				} while (Integer.toString(mdp2).length() < 6);
				
				correct = mdp == mdp2 ? false: true;
			}
		}
		
		int res = !correct? 1 : 0;
		return res;
		
	}
	
	private void reserveChambre() {
		/**
		 * A method to print the reserved room
		 */
		for(Chambre chambre : this.getChambres()) {
			if(chambre.equals(this.chambresVides().get(0))) {
				chambre.setReserve(true);
				System.out.println("\n---------------------------------------\nVous avez bien réservé cette chambre: |");
				System.out.println(chambre.toString());
				break;
			}
		}
	}
	private String reserver() {
		
		/**
		 * A method to reserve a room
		 */
		Scanner scan2 = new Scanner(System.in);
		System.out.println("\n---------------------------------------\nNotre première chambre libre est :    |\n"+this.chambresVides().get(0).toString()+"\n");
		System.out.print("Pourtant, pour réserver une chambre, il faut que vous soiez inscrit ou admin!\nEtes vous admin ? O/N : ");
		String rep = scan2.next();
		String inscription="";
		if(rep.equalsIgnoreCase("o")) {
			int check = this.adminLogin();
			if(check==1) {
				System.out.println("\n------------------\n| Bonjour Ibobai |\n------------------");
				this.reserveChambre();
				inscription = "\n-------------------------------\nC'est bien fait Admin, bon travail!\n-------------------------------";
			}else {
				System.err.print("\n-------------------------------\n\t XXX\nVous n'êtes pas un admin!\n-------------------------------");
			}
		}else if (rep.equalsIgnoreCase("n")) {
			System.out.print("\nVoulez vous vous inscrire O/N ? ");
			inscription = scan2.next();
			if(inscription.equalsIgnoreCase("o")) {
				if(this.userLoing() == 1) {
					System.out.println("\n-----------------------------------------------\nInscription fini!\n-----------------------------------------------");
					//if the user wanted to reserve a room
						System.out.println("Mr/Mme Utilisateur.");
						this.reserveChambre();
						inscription="\n-------------------------------\nMerci pour votre réservation!\n-------------------------------";
						
				}else {
					inscription="\n-------------------------------\nVotre inscription a été annulée\n-------------------------------";
				}
			}else if(inscription.equalsIgnoreCase("n")) {
				inscription= "\n-------------------------------\nVotre inscription a été annulée\n-------------------------------";
			} else {
				inscription = "-------------------------------\nVotre saisie n'est pas correct!\n-------------------------------";
			}
		}else if(rep.equalsIgnoreCase("q") || rep.equalsIgnoreCase("quit")) {
			inscription = "q";
		}
		
		else {
			System.out.println();
			System.err.print("---------------------------\nVotre saisie est incorrect!\n---------------------------");
		}
		
		return inscription;
		
	}
	
	
	
	private void afficheMenu() {
		/**
		 * A method to print the menu.
		 */
		System.out.println("------------------------------   Bien venu -----------------------------");
		System.out.println("--------------------------- "+this.getName()+" ------------------------\n");
		
		try {
			Thread.sleep(40);
			System.out.println("A- Afficher l'état de l'hôtel. ");
			Thread.sleep(50);
			System.out.println("B- Afficher Le nombre de chambres réservées.");
			Thread.sleep(60);
			System.out.println("C- Afficher Le nombre de chambres libres.");
			Thread.sleep(70);
			System.out.println("D- Afficher Le numéro de la première chambre vide.");
			Thread.sleep(80);
			System.out.println("E- Afficher La numéro de la dernière chambre vide.");
			Thread.sleep(90);
			System.out.println("F- Reserver une chambre.");
			Thread.sleep(100);
			System.out.println("G- Libérer une chambre.");
			Thread.sleep(100);
			System.out.println("O- Voire toutes les options possibles?");
			Thread.sleep(100);
			System.out.println("H- Aide?");
			Thread.sleep(100);
			System.out.println("-------------------------------------------------------------------------");
		}catch(Exception err) {
			System.out.println("Error d'affichage!");
		}
	
	}
	
	
	private String optionsManager() {
		/**
		 * A method to handle the options entered
		 * 
		 */
		System.out.print("\nEntrez votre choix SVP: ");
		Scanner scan = new Scanner(System.in);
		String option = "";
		option = scan.nextLine();
		
		String etatDeHotel = this.isOuvert()? "L'Hôtel est ouvert ! " : "L'Hôtel n'est pas ouvert ! ";		
		String doitEtreAfficher = option.equalsIgnoreCase("A")? "\n"+etatDeHotel+"\n" 
				: option.equalsIgnoreCase("B")? "\nLe nombre de chambres réservées est: "+ this.chambresNonVides().size()+"\n"
				: option.equalsIgnoreCase("C") ? "\nLe nombre de chambres vides est: "+ this.chambresVides().size()+"\n"
				: option.equalsIgnoreCase("D")? "\nLe nombre de la première chambre vide est : "+this.chambresVides().get(0).getId()+"\n"
				: option.equalsIgnoreCase("E")? "\nLe nombre de la dernière chambre vide est : "+this.chambresVides().get(this.chambresVides().size()-1).getId()+"\n"
				: option.equalsIgnoreCase("H")? "\n-La commande Q ou Quit sont pour arrêtrer le programe.\n-Il faut choisir un letter pour les options.\n-La commande O pour afficher toutes les options possibles! "
				: option.equalsIgnoreCase("n")? "----------------------------------\nVous avez été dirigé vers le menu principale"
				: option.equalsIgnoreCase("m")? "\n-----------\nMerci\n----------------\n"
				: option.equalsIgnoreCase("q")? "q"
				: option.equalsIgnoreCase("quit")? "q"
				: option.equalsIgnoreCase("o")? "o"
				: option.equalsIgnoreCase("f")? "f"
				: option.equalsIgnoreCase("g")? "g"
				:"x";
		return doitEtreAfficher;
	}
	
	
	
	//pour la gestion d'hotle
	public void gestionDeHotel() {
		
		/**
		 * A method for the gestion of the hotel
		 */
				this.afficheMenu();
				Scanner scan = new Scanner(System.in);
				String choix = "";
				
				while( this.isOuvert() ) {
					String rep = this.optionsManager();
					
					if(rep.equals("o")) {
						this.afficheMenu();
					}else if(rep.equals("q")) {
						System.out.println("Au revoire !");
						break;
					}else if (rep.equals("x")) {
						System.out.println();
						System.err.print("----------------------------\nVotre sasie est incorrect!  |\n----------------------------");
					}
					
					else if (rep.equals("f")){
						String verif = this.reserver();
						if(verif.equals("q")) {
							System.out.println("Au revoire !");
							break;
						}else {
							System.err.print(verif);
						}
						
					}else if (rep.equals("g")){
						this.liberateAroom();
					}
					else {
						System.out.print(rep);
					}
					
				}
				while(!this.isOuvert()) {
					String etatDeHotel = this.isOuvert()? "L'Hôtel est ouvert ! " : "L'Hôtel n'est pas ouvert ! ";		
					String rep = this.optionsManager();
					if(rep.equals("o")) {
						this.afficheMenu();
					}else if(rep.equals("\n"+etatDeHotel+"\n")){
						System.out.print(rep);
					}
					else if(rep.equals("q")) {
						System.out.println("Au revoire !");
						break;
					}else if (rep.equals("\n-La commande Q ou Quit sont pour arrêtrer le programe.\n-Il faut choisir un letter pour les options.\n-La commande O pour afficher toutes les options possibles! ")) {
						System.out.println(rep);
					}
					else {
						System.err.print("\n-------------------------------------------------------------------------\nDésolé, l'hôtel est fermé!\nVous pouvez utiliser que l'option |o| et |Q ou Quit|\n-------------------------------------------------------------------------");
					}
				}
				
				

	}
	@Override
	public String toString() {
		return "Hotel [ouvert=" + ouvert + ", name=" + name + ", chambres=" + chambres + "]";
	}
	
	
	
	

}
