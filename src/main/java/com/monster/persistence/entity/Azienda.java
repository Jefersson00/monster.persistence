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
 * The persistent class for the azienda database table.
 * 
 */
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
@Table(name="azienda")
@NamedQuery(name="Azienda.findAll", query="SELECT a FROM Azienda a")
public class Azienda  {
//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="anno_fondazione")
	private Date annoFondazione;
	
	private String descrizione;
	
	@Column(unique = true)
	private String email;
	
	private String link;
	
	private String logo;
	
	@Column(unique = true)
	private String nome;
	
	@Column(name="numero_dipendenti")
	private int numeroDipendenti;
	
	private String password;
	
	private String settore;

	//bi-directional many-to-one association to Sede
	@OneToMany(mappedBy="azienda")
	private List<Sede> sedes;

	
}