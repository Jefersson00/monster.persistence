package com.monster.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the azienda database table.
 * 
 */
@Entity
@Table(name="azienda")
@NamedQuery(name="Azienda.findAll", query="SELECT a FROM Azienda a")
public class Azienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="anno_fondazione")
	private Date annoFondazione;

	private String decrizione;

	private String email;

	private String link;

	private String logo;

	private String nome;

	@Column(name="numero_dipendenti")
	private int numeroDipendenti;

	private String password;

	private String settore;

	//bi-directional many-to-one association to Sede
	@OneToMany(mappedBy="azienda")
	private List<Sede> sedes;

	public Azienda() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAnnoFondazione() {
		return this.annoFondazione;
	}

	public void setAnnoFondazione(Date annoFondazione) {
		this.annoFondazione = annoFondazione;
	}

	public String getDecrizione() {
		return this.decrizione;
	}

	public void setDecrizione(String decrizione) {
		this.decrizione = decrizione;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroDipendenti() {
		return this.numeroDipendenti;
	}

	public void setNumeroDipendenti(int numeroDipendenti) {
		this.numeroDipendenti = numeroDipendenti;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSettore() {
		return this.settore;
	}

	public void setSettore(String settore) {
		this.settore = settore;
	}

	public List<Sede> getSedes() {
		return this.sedes;
	}

	public void setSedes(List<Sede> sedes) {
		this.sedes = sedes;
	}

	public Sede addSede(Sede sede) {
		getSedes().add(sede);
		sede.setAzienda(this);

		return sede;
	}

	public Sede removeSede(Sede sede) {
		getSedes().remove(sede);
		sede.setAzienda(null);

		return sede;
	}

}