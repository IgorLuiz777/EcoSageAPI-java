package br.com.ecosage.repository;

import br.com.ecosage.model.EquipmentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentCategoryRepository extends JpaRepository<EquipmentCategory, Long> {
}
