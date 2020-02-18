package service.models;

import java.io.Serializable;
import java.util.List;

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Station{

	
	public Station(String nom, String ville, String adresse) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.adresse = adresse;
	}
	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	private int id_s;

	private String nom;

	private String ville;

	private String adresse;

	
	/*
	 * @OneToMany(mappedBy = "station") List<Station> stations;
	 */
	
	public int getId_s() {
		return id_s;
	}
	public void setId_s(int id_s) {
		this.id_s = id_s;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}