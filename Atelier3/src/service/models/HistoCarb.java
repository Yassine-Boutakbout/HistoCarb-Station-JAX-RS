package service.models;

import java.util.Date;


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

	private Long id_h;

	private Date date;

	private double prix;

	private Station station;

	private Carburant carburant;
}
