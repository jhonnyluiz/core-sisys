package com.jlcabral.core.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

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
public class Role extends AppEntity<String> implements GrantedAuthority {
	private static final long serialVersionUID = 1079060002102212412L;
	
	@Id
	@EqualsAndHashCode.Include
    private String id;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<OperacaoSistema> allowedOperations;
    
    @Override
    public String getAuthority() {
        return  this.id;
    }
}
