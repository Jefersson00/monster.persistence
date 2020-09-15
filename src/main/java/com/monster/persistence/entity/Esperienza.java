package com.monster.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the esperienza database table.
 * 
 */
@Entity
@Table(name="esperienza")
@NamedQuery(name="Esperienza.findAll", query="SELECT e FROM Esperienza e")
public class Esperienza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String descrizione;

	@Column(name="nome_azienda")
	private String nomeAzienda;

	//bi-directional many-to-one association to UtenteEsperienza
	@OneToMany(mappedBy="esperienza")
	private List<UtenteEsperienza> utenteEsperienzas;

	public Esperienza() {
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

	public String getNomeAzienda() {
		return this.nomeAzienda;
	}

	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

	public List<UtenteEsperienza> getUtenteEsperienzas() {
		return this.utenteEsperienzas;
	}

	public void setUtenteEsperienzas(List<UtenteEsperienza> utenteEsperienzas) {
		this.utenteEsperienzas = utenteEsperienzas;
	}

	public UtenteEsperienza addUtenteEsperienza(UtenteEsperienza utenteEsperienza) {
		getUtenteEsperienzas().add(utenteEsperienza);
		utenteEsperienza.setEsperienza(this);

		return utenteEsperienza;
	}

	public UtenteEsperienza removeUtenteEsperienza(UtenteEsperienza utenteEsperienza) {
		getUtenteEsperienzas().remove(utenteEsperienza);
		utenteEsperienza.setEsperienza(null);

		return utenteEsperienza;
	}

	@Override
	public String toString() {
		return "Esperienza [id=" + id + ", descrizione=" + descrizione + ", nomeAzienda=" + nomeAzienda
				+ ", utenteEsperienzas=" + utenteEsperienzas + "]";
	}

}