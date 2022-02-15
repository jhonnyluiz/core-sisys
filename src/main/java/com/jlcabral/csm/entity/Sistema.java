package com.jlcabral.csm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jlcabral.core.entity.AppEntity;
import com.jlcabral.csm.enumerated.TypeSituacaoEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SISTEMAS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_EMPTY)
public class Sistema extends AppEntity<Long> {
	private static final long serialVersionUID = -5700723445596272388L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "ID_SISTEMA")
	private Long id;

	@Column(name = "NOME_SISTEMA", length = 50, nullable = false)
	private String nome;

	@Column(name = "COD_SISTEMA", length = 25, nullable = false)
	private String codigo;

	@Column(name = "DESC_SISTEMA")
	private String descricao;

	@Column(name = "URL_SISTEMA")
	private String url;

	@Column(name = "TP_SITUACAO", length = 25)
	@Enumerated(EnumType.STRING)
	private TypeSituacaoEnum typeSituacao;

    @JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "sistema", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemMenu> itensMenu;
}
