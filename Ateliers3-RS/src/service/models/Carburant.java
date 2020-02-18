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
	
	
	public Carburant(String nom, String decription) {
		super();
		this.nom = nom;
		this.decription = decription;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_c;
	
	@Column(nullable = true, length=255)
	private String nom;
	
	@Column(nullable = true, length=2550)
	private String decription;
	
	@OneToMany(mappedBy = "carburant", fetch = FetchType.LAZY)
	private List<HistoCarb> hcs;
}
