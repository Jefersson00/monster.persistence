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
 * The persistent class for the esperienza database table.
 * 
 */
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
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


}