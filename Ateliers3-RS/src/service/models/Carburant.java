package service.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Carburant")
@Table(name="Carburant")
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

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_c;
	
	@Column(nullable = true, length=255)
	private String nom;
	
	@Column(nullable = true, length=2550)
	private String description;
	
	@OneToMany(mappedBy = "carburant", fetch = FetchType.LAZY)
	private List<HistoCarb> hcs;

	
	
	public int getId_c() {
		return id_c;
	}

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
