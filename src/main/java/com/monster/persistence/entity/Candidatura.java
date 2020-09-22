package com.monster.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * The persistent class for the candidatura database table.
 * 
 */
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
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



}