package service.models;


import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name="Station")
@Table(name="Station")
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id_s;
	
	@Column(nullable = true, length=255)
	private String nom;

	@Column(nullable = true, length=255)
	private String ville;
	
	@Column(nullable = true, length=255)
	private String adresse;

	
	
	@OneToMany(mappedBy = "station", fetch = FetchType.LAZY)
	private List<HistoCarb> hcs;
	 
	
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