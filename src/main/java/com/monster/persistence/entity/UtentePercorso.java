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
 * The persistent class for the utente_percorso database table.
 * 
 */
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
@Table(name="utente_percorso")
@NamedQuery(name="UtentePercorso.findAll", query="SELECT u FROM UtentePercorso u")
public class UtentePercorso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to PercorsoFormativo
	@ManyToOne
	@JoinColumn(name="id_percorso_formativo")
	private PercorsoFormativo percorsoFormativo;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="id_utente")
	private Utente utente;

}