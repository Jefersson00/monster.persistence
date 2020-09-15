package com.monster.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the candidatura database table.
 * 
 */
@Entity
@Table(name="candidatura")
@NamedQuery(name="Candidatura.findAll", query="SELECT c FROM Candidatura c")
public class Candidatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to Annuncio
	@ManyToOne
	@JoinColumn(name="id_annuncio")
	private Annuncio annuncio;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="id_utente")
	private Utente utente;

	public Candidatura() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Annuncio getAnnuncio() {
		return this.annuncio;
	}

	public void setAnnuncio(Annuncio annuncio) {
		this.annuncio = annuncio;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}