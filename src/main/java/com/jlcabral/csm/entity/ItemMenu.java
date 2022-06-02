package com.jlcabral.csm.entity;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

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
import com.jlcabral.core.util.ObjUtil;

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
	@JoinColumn(name = "ID_SISTEMA", nullable = false)
	private Sistema sistema;
	
	@Column(name = "ID_SISTEMA", insertable = false, updatable = false)
	private Long sistemaId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_ITENS_MENU_PAI")
	private ItemMenu itemPai;
	
	@Column(name = "ID_ITENS_MENU_PAI", insertable = false, updatable = false)
	private Long itemPaiId;

	@OneToMany(mappedBy = "itemPai", cascade = CascadeType.ALL)
	private List<ItemMenu> items;

	@Column(name = "ORDER_ITEM", nullable = false)
	private Integer order;

	public String getRouterLink() {
		return url;
	}

	@JsonIgnore
	public ItemMenu setData(Sistema sistema, ItemMenu itemPai) {
		this.sistema = sistema;
		this.itemPai = itemPai;
		if (ObjUtil.isNotEmpty(items)) {
			this.items.forEach(i -> i.setData(sistema, this));
		}
		return this;
	}

	public List<ItemMenu> getItems() {
		if (ObjUtil.isNotEmpty(this.items)) {
			return this.items.stream().sorted(comparing(ItemMenu::getOrder)).collect(toList());
		}
		return this.items;
	}
}
