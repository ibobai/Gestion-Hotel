package theMainPakage;


public class Chambre {
	
	/**
	 * A class to create a room.
	 */
	private Boolean reserve = false;
	private String name;
	private Integer id;
	
	public Chambre(String name,Integer id,Boolean reserve) {
		super();
		this.reserve = reserve;
		this.id = id;
		this.name = name;
		
	}
	
    public Chambre() {
		
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public boolean isReserve() {
		return reserve;
	}

	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String res = this.isReserve() ? "la chambre est réservée !" : "la chambre n'est pas réservée!";
		return "---------------------------------------\n| Nom: "+ name + "\n| Id: "+id+"\n| Etat: " + res+"\n---------------------------------------";
	}
	
	
	
	
}
