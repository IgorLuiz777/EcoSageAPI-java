package br.com.ecosage.controller;

import br.com.ecosage.model.EquipmentCategory;
import br.com.ecosage.service.EquipmentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class EquipmentCategoryController {

    @Autowired
    private EquipmentCategoryService categoryService;

    @GetMapping()
    public ResponseEntity<?> getAllCategories() {
        return categoryService.CategoriesList();
    }

    @PostMapping()
    public ResponseEntity<?> postCategory(@RequestBody EquipmentCategory category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putCategory(@PathVariable Long id, @RequestBody EquipmentCategory category) {
        return categoryService.editCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategory(id);
    }
}
