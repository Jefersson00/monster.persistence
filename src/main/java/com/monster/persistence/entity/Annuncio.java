package com.monster.persistence.entity;

//import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
//

/**
 * The persistent class for the annuncio database table.
 * 
 */
@Entity
@Table(name="annuncio")
@NamedQuery(name="Annuncio.findAll", query="SELECT a FROM Annuncio a")
public class Annuncio {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String contratto;

	@Temporal(TemporalType.DATE)
	@Column(name="data_pubblicazione")
	private Date dataPubblicazione;

	private String descrizione;

	//bi-directional many-to-one association to Sede
	@ManyToOne
	@JoinColumn(name="id_sede")
	private Sede sede;

	//bi-directional many-to-one association to Settore
	@ManyToOne
	@JoinColumn(name="id_settore")
	private Settore settore;

	//bi-directional many-to-one association to Candidatura
	@OneToMany(mappedBy="annuncio")
	private List<Candidatura> candidaturas;

	public Annuncio() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContratto() {
		return this.contratto;
	}

	public void setContratto(String contratto) {
		this.contratto = contratto;
	}

	public Date getDataPubblicazione() {
		return this.dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Sede getSede() {
		return this.sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Settore getSettore() {
		return this.settore;
	}

	public void setSettore(Settore settore) {
		this.settore = settore;
	}

	public List<Candidatura> getCandidaturas() {
		return this.candidaturas;
	}

	public void setCandidaturas(List<Candidatura> candidaturas) {
		this.candidaturas = candidaturas;
	}

	public Candidatura addCandidatura(Candidatura candidatura) {
		getCandidaturas().add(candidatura);
		candidatura.setAnnuncio(this);

		return candidatura;
	}

	public Candidatura removeCandidatura(Candidatura candidatura) {
		getCandidaturas().remove(candidatura);
		candidatura.setAnnuncio(null);

		return candidatura;
	}

	@Override
	public String toString() {
		return "Annuncio [id=" + id + ", contratto=" + contratto + ", dataPubblicazione=" + dataPubblicazione
				+ ", descrizione=" + descrizione + ", sede=" + sede + ", settore=" + settore + ", candidaturas="
				+ candidaturas + "]";
	}

}