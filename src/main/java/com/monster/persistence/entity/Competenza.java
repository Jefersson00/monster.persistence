package com.monster.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


/**
 * The persistent class for the competenza database table.
 * 
 */
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
@Table(name="competenza")
@NamedQuery(name="Competenza.findAll", query="SELECT c FROM Competenza c")
public class Competenza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String descrizione;
	
	@Column(unique = true)
	private String nome;

	//bi-directional many-to-one association to UtenteCompetenza
	@OneToMany(mappedBy="competenza")
	private List<UtenteCompetenza> utenteCompetenzas;


}