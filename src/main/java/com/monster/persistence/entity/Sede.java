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
 * The persistent class for the sede database table.
 * 
 */
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
@Table(name="sede")
@NamedQuery(name="Sede.findAll", query="SELECT s FROM Sede s")
public class Sede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String citta;

	private String regione;

	//bi-directional many-to-one association to Annuncio
	@OneToMany(mappedBy="sede")
	private List<Annuncio> annuncios;

	//bi-directional many-to-one association to Azienda
	@ManyToOne
	@JoinColumn(name="id_azienda")
	private Azienda azienda;

}