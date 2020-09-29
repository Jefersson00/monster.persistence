package com.monster.persistence.entity;

//import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
//

/**
 * The persistent class for the annuncio database table.
 * 
 */

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
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
}