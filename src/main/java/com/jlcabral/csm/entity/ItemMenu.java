package com.jlcabral.csm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jlcabral.core.entity.AppEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "ITENS_MENU")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_EMPTY)
public class ItemMenu extends AppEntity<Long> {
	private static final long serialVersionUID = -4000449371919630450L;

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include	
	@Column(name = "ID_ITENS_MENU")
	private Long id;

	@Column(name = "LABEL_MENU", nullable = false)
	private String label;

	@Column(name = "ICON_MENU")
	private String icon;

	@Column(name = "URL_MENU")
	private String url;

	@Column(name = "DISABLED")
	@Builder.Default
	private boolean disabled = false;

	@Column(name = "VISIBLE")
	@Builder.Default
	private boolean visible = true;

	@Column(name = "BADGE")
	private String badge;

	@Column(name = "TOOLTIP")
	private String tooltip;

	@Column(name = "TOOLTIP_POSITION")
	private String tooltipPosition;

	@Column(name = "STYLE_CLASS")
	private String styleClass;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_SISTEMA")
	private Sistema sistema;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_ITENS_MENU_PAI")
	private ItemMenu itemPai;

	@OneToMany(mappedBy = "itemPai", cascade = CascadeType.ALL)
	private List<ItemMenu> items;
}
