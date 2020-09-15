package com.monster.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the utente_esperienza database table.
 * 
 */
@Entity
@Table(name="utente_esperienza")
@NamedQuery(name="UtenteEsperienza.findAll", query="SELECT u FROM UtenteEsperienza u")
public class UtenteEsperienza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_fine")
	private Date dataFine;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inizio")
	private Date dataInizio;

	//bi-directional many-to-one association to Esperienza
	@ManyToOne
	@JoinColumn(name="id_esperienza")
	private Esperienza esperienza;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="id_utente")
	private Utente utente;

	public UtenteEsperienza() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Esperienza getEsperienza() {
		return this.esperienza;
	}

	public void setEsperienza(Esperienza esperienza) {
		this.esperienza = esperienza;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "UtenteEsperienza [id=" + id + ", dataFine=" + dataFine + ", dataInizio=" + dataInizio + ", esperienza="
				+ esperienza + ", utente=" + utente + "]";
	}

}