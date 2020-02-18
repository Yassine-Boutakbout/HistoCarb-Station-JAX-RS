package service.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="HistoCarb")
@Table(name="HistoCarb")
public class HistoCarb {
	
	public HistoCarb(Date date, double prix, Station station, Carburant carburant) {
		super();
		this.date = date;
		this.prix = prix;
		this.station = station;
		this.carburant = carburant;
	}

	public HistoCarb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id_h;
	}

	public void setId(Long id_h) {
		this.id_h = id_h;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public Carburant getCarburant() {
		return carburant;
	}

	public void setCarburant(Carburant carburant) {
		this.carburant = carburant;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_h;
	
	@Column(nullable = true, name = "Date")
	private Date date;
	
	@Column(nullable = true, name = "prix")
	private double prix;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_station")
	private Station station;

	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_carburant")
	private Carburant carburant;
}
