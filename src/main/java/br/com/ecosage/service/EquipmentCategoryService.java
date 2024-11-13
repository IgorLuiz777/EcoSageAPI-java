package br.com.ecosage.service;

import br.com.ecosage.model.EquipmentCategory;
import br.com.ecosage.repository.EquipmentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentCategoryService {

    @Autowired
    private EquipmentCategoryRepository equipmentCategoryRepository;

    public ResponseEntity<?> CategoriesList() {
        try {
            List<EquipmentCategory> equipmentCategories = equipmentCategoryRepository.findAll();
            return ResponseEntity.ok(equipmentCategories);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to get Categories" + e);
        }
    }

    public ResponseEntity<?> createCategory(EquipmentCategory category) {
        try {
            EquipmentCategory createdCategory = equipmentCategoryRepository.save(category);
            return ResponseEntity.ok(createdCategory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to create Category" + e);
        }
    }

    public ResponseEntity<?> getCategory(Long id) {
        Optional<EquipmentCategory> category = equipmentCategoryRepository.findById(id);
        if (!category.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category NOT FOUND, ID: " + id);
        try {
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR)).body("Error to get Category, with ID:  " + id);
        }
    }

    public ResponseEntity<?> editCategory(Long id, EquipmentCategory category) {
        Optional<EquipmentCategory> existsCategory = equipmentCategoryRepository.findById(id);
        if (!existsCategory.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category NOT FOUND, ID: " + id);
        try {
            category.setId(id);
            EquipmentCategory createdCategory = equipmentCategoryRepository.save(category);
            return ResponseEntity.ok(createdCategory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to edit Category, ID: " + id);
        }
    }

    public ResponseEntity<?> deleteCategory(Long id) {
        Optional<EquipmentCategory> existsCategory = equipmentCategoryRepository.findById(id);
        if (!existsCategory.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category NOT FOUND, ID: " + id);
        try {
            equipmentCategoryRepository.deleteById(id);
            return ResponseEntity.ok("Category deleted, ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to delete Category, ID: " + id);
        }
    }
}
