package com.monster.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utente database table.
 * 
 */
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
@Table(name="utente")
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String cognome;

	private String cv;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nascita")
	private Date dataNascita;
	
	@Column(unique = true)
	private String email;

	private String nome;

	private String password;
	
	@Column(unique = true)
	private String telefono;

	//bi-directional many-to-one association to Candidatura
	@OneToMany(mappedBy="utente")
	private List<Candidatura> candidaturas;

	//bi-directional many-to-one association to UtenteCompetenza
	@OneToMany(mappedBy="utente")
	private List<UtenteCompetenza> utenteCompetenzas;

	//bi-directional many-to-one association to UtenteEsperienza
	@OneToMany(mappedBy="utente")
	private List<UtenteEsperienza> utenteEsperienzas;

	//bi-directional many-to-one association to UtentePercorso
	@OneToMany(mappedBy="utente")
	private List<UtentePercorso> utentePercorsos;

}