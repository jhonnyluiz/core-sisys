package com.jlcabral.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jlcabral.core.enumerated.TypeGenderEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person implements Serializable {
	private static final long serialVersionUID = -1442462012281250222L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@EqualsAndHashCode.Include
	private Long id;
	private String nome;
	private String nomeSocial;
	private TypeGenderEnum sexo;
	private String cpf;
	private Date dataNascimento;

	private String registroGeral;
	private String orgaoRegistroGeral;
	private Date expedicaoRegistroGeral;

	private Person mae;
	private Person pai;
}
