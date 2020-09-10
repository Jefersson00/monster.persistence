package com.monster.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the utente_percorso database table.
 * 
 */
@Entity
@Table(name="utente_percorso")
@NamedQuery(name="UtentePercorso.findAll", query="SELECT u FROM UtentePercorso u")
public class UtentePercorso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to PercorsoFormativo
	@ManyToOne
	@JoinColumn(name="id_percorso_formativo")
	private PercorsoFormativo percorsoFormativo;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="id_utente")
	private Utente utente;

	public UtentePercorso() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PercorsoFormativo getPercorsoFormativo() {
		return this.percorsoFormativo;
	}

	public void setPercorsoFormativo(PercorsoFormativo percorsoFormativo) {
		this.percorsoFormativo = percorsoFormativo;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}