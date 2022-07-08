package com.jlcabral.core.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ItemMenuDTO extends AppDTO {
	private static final long serialVersionUID = -4577615062231534675L;

	private Long id;
	private String label;
	private String icon;
	private String url;
	private boolean disabled;
	private boolean visible;
	private String badge;
	private String tooltip;
	private String tooltipPosition;
	private String styleClass;
	private Integer order;
	private List<ItemMenuDTO> items;
	private Long sistemaId;
	private Long itemPaiId;
}
