package service.models;

import java.io.Serializable;


public class Carburant implements Serializable{

		
	public Carburant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Carburant(String nom, String decription) {
		super();
		this.nom = nom;
		this.decription = decription;
	}

	
	private int id_c;
	private String nom;
	private String decription;
	
	/*
	 * @OneToMany(mappedBy = "carburant") List<Carburant> carburant;
	 */
}
