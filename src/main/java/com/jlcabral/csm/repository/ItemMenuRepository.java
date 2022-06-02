package com.jlcabral.csm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jlcabral.csm.dto.SelectDTO;
import com.jlcabral.csm.entity.ItemMenu;

@Repository
public interface ItemMenuRepository extends JpaRepository<ItemMenu, Long>{

	@Query("SELECT new com.jlcabral.csm.dto.SelectDTO(im.id, im.label) "
		+ " FROM ItemMenu im "
		+ " WHERE im.sistema.id = :sistemaId "
		+ " AND (:filterText IS NULL OR UPPER(im.label) LIKE UPPER(:filterText))")
	List<SelectDTO> findListSelect(Long sistemaId, String filterText);

}
