package com.monster.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sede database table.
 * 
 */
@Entity
@Table(name="sede")
@NamedQuery(name="Sede.findAll", query="SELECT s FROM Sede s")
public class Sede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String citta;

	private String regione;

	//bi-directional many-to-one association to Annuncio
	@OneToMany(mappedBy="sede")
	private List<Annuncio> annuncios;

	//bi-directional many-to-one association to Azienda
	@ManyToOne
	@JoinColumn(name="id_azienda")
	private Azienda azienda;

	public Sede() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getRegione() {
		return this.regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public List<Annuncio> getAnnuncios() {
		return this.annuncios;
	}

	public void setAnnuncios(List<Annuncio> annuncios) {
		this.annuncios = annuncios;
	}

	public Annuncio addAnnuncio(Annuncio annuncio) {
		getAnnuncios().add(annuncio);
		annuncio.setSede(this);

		return annuncio;
	}

	public Annuncio removeAnnuncio(Annuncio annuncio) {
		getAnnuncios().remove(annuncio);
		annuncio.setSede(null);

		return annuncio;
	}

	public Azienda getAzienda() {
		return this.azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

	@Override
	public String toString() {
		return "Sede [id=" + id + ", citta=" + citta + ", regione=" + regione + ", annuncios=" + annuncios
				+ ", azienda=" + azienda + "]";
	}

}