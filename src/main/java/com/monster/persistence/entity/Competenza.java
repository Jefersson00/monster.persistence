package com.monster.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the competenza database table.
 * 
 */
@Entity
@Table(name="competenza")
@NamedQuery(name="Competenza.findAll", query="SELECT c FROM Competenza c")
public class Competenza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String descrizione;

	private String nome;

	//bi-directional many-to-one association to UtenteCompetenza
	@OneToMany(mappedBy="competenza")
	private List<UtenteCompetenza> utenteCompetenzas;

	public Competenza() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<UtenteCompetenza> getUtenteCompetenzas() {
		return this.utenteCompetenzas;
	}

	public void setUtenteCompetenzas(List<UtenteCompetenza> utenteCompetenzas) {
		this.utenteCompetenzas = utenteCompetenzas;
	}

	public UtenteCompetenza addUtenteCompetenza(UtenteCompetenza utenteCompetenza) {
		getUtenteCompetenzas().add(utenteCompetenza);
		utenteCompetenza.setCompetenza(this);

		return utenteCompetenza;
	}

	public UtenteCompetenza removeUtenteCompetenza(UtenteCompetenza utenteCompetenza) {
		getUtenteCompetenzas().remove(utenteCompetenza);
		utenteCompetenza.setCompetenza(null);

		return utenteCompetenza;
	}

	@Override
	public String toString() {
		return "Competenza [id=" + id + ", descrizione=" + descrizione + ", nome=" + nome + ", utenteCompetenzas="
				+ utenteCompetenzas + "]";
	}

}