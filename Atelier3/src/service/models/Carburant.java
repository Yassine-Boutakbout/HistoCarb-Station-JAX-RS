package service.models;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSetter;

public class Carburant implements Serializable{

		
	public Carburant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Carburant(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

	
	private int id_c;
	private String nom;
	private String description;	
	
	@JsonIgnore
	public int getId_c() {
		return id_c;
	}
	@JsonSetter
	public void setId_c(int id_c) {
		this.id_c = id_c;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
