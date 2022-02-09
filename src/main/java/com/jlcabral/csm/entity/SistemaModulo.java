package com.jlcabral.csm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jlcabral.core.entity.AppEntity;
import com.jlcabral.csm.enumerated.TypeModuloEnum;
import com.jlcabral.csm.enumerated.TypeSituacaoEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MODULOS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SistemaModulo extends AppEntity<Long> {
	private static final long serialVersionUID = -5700723445596272388L;

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	@Column(name = "ID_MODULO")
	public Long id;

	@Column(name = "NOME_MODULO", length = 50)
	private String nome;

	@Column(name = "COD_MODULO", length = 25)
	private String codigo;

	@Column(name = "TP_SITUACAO", length = 25)
	@Enumerated(EnumType.STRING)
	private TypeSituacaoEnum typeSituacao;
	
	@Column(name = "TP_MODULO", length = 25)
	@Enumerated(EnumType.STRING)
	private TypeModuloEnum typeModulo;

	@Column(name = "URL_MODULO", length = 100)
	private String urlModulo;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ID_SISTEMA")
	private Sistema sistema;

	@ManyToOne
	@JoinColumn(name = "ID_MODULO_VINC")
	private SistemaModulo moduloVinculado;

	@OneToMany(mappedBy = "moduloVinculado", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SistemaModulo> modulosFilhos;

}
