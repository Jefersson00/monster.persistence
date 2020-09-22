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
 * The persistent class for the percorso_formativo database table.
 * 
 */
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
@Table(name="percorso_formativo")
@NamedQuery(name="PercorsoFormativo.findAll", query="SELECT p FROM PercorsoFormativo p")
public class PercorsoFormativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String descrizione;
	
	@Column(unique = true)
	private String formazione;

	//bi-directional many-to-one association to UtentePercorso
	@OneToMany(mappedBy="percorsoFormativo")
	private List<UtentePercorso> utentePercorsos;


}