package br.com.ecosage.controller;

import br.com.ecosage.model.Equipment;
import br.com.ecosage.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping()
    public ResponseEntity<?> getAllEquipments() {
        return equipmentService.equipmentsList();
    }

    @PostMapping()
    public ResponseEntity<?> postEquipment(@RequestBody Equipment equipment) {
        return equipmentService.createEquipment(equipment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEquipmentById(@PathVariable Long id) {
        return equipmentService.getEquipment(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putEquipment(@PathVariable Long id, @RequestBody Equipment equipment) {
        return equipmentService.putEquipment(id, equipment);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEquipment(@PathVariable Long id) {
        return equipmentService.deleteEquipment(id);
    }
}
