package com.monster.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the settore database table.
 * 
 */
@Entity
@Table(name="settore")
@NamedQuery(name="Settore.findAll", query="SELECT s FROM Settore s")
public class Settore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String descrizione;

	private String nome;

	//bi-directional many-to-one association to Annuncio
	@OneToMany(mappedBy="settore")
	private List<Annuncio> annuncios;

	public Settore() {
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

	public List<Annuncio> getAnnuncios() {
		return this.annuncios;
	}

	public void setAnnuncios(List<Annuncio> annuncios) {
		this.annuncios = annuncios;
	}

	public Annuncio addAnnuncio(Annuncio annuncio) {
		getAnnuncios().add(annuncio);
		annuncio.setSettore(this);

		return annuncio;
	}

	public Annuncio removeAnnuncio(Annuncio annuncio) {
		getAnnuncios().remove(annuncio);
		annuncio.setSettore(null);

		return annuncio;
	}

}