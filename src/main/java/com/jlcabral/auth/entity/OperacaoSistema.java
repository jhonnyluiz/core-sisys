package com.jlcabral.auth.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import com.jlcabral.core.entity.AppEntity;

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
public class OperacaoSistema extends AppEntity<String> implements GrantedAuthority {
	private static final long serialVersionUID = 2376242472099504627L;
	
	@Id
	@EqualsAndHashCode.Include
    private String id;

    @Override
    public String getAuthority() {
        return id;
    }
}
