package com.jlcabral.auth.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jlcabral.core.entity.AppEntity;
import com.jlcabral.core.enumerated.SimNaoEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Usuario extends AppEntity<Long> {
	private static final long serialVersionUID = 2660342569725144897L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@EqualsAndHashCode.Include
	private Long id;

	@Column(unique = true)
	private String username;

	@JsonIgnore
	private String password;

	private LocalDate dataExpiracaoConta;
	private LocalDate dataExpiracaoCredencial;

	private SimNaoEnum contaAtiva;
	private SimNaoEnum contaBloqueada;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_role", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

	public Usuario(Usuario u) {
		this.id = u.getId();
		this.username = u.getUsername();
		this.password = u.getPassword();
		this.dataExpiracaoConta = u.getDataExpiracaoConta();
		this.dataExpiracaoCredencial = u.getDataExpiracaoCredencial();
		this.contaAtiva = u.getContaAtiva();
		this.contaBloqueada = u.getContaBloqueada();
		this.roles = u.getRoles();
	}
}
