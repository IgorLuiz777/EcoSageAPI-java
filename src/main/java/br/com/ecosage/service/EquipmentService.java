package br.com.ecosage.service;

import br.com.ecosage.model.Equipment;
import br.com.ecosage.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public ResponseEntity<?> equipmentsList() {
        try {
            List<Equipment> equipments = equipmentRepository.findAll();
            return ResponseEntity.ok(equipments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }

    public ResponseEntity<?> createEquipment(Equipment equipment) {
        try {
            Equipment createdEquipment = equipmentRepository.save(equipment);
            return ResponseEntity.ok(createdEquipment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error to create: " + e.getMessage());
        }
    }

    public ResponseEntity<?> getEquipment(Long id) {
        Optional<Equipment> equipment = equipmentRepository.findById(id);
        if (!equipment.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipment NOT FOUND, with " +
                "ID: " + id);
        try {
            return ResponseEntity.ok(equipment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to get equipment, with ID: " + id);
        }
    }

    public ResponseEntity<?> putEquipment(Long id, Equipment equipment) {
        Optional<Equipment> existsEquipment = equipmentRepository.findById(id);
        if (!existsEquipment.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipment NOT FOUND, with " +
                "ID: " + id);
        try {
            equipment.setId(id);
            Equipment editedEquipment = equipmentRepository.save(equipment);
            return ResponseEntity.ok(editedEquipment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to edit equipment, with ID: " + id);
        }
    }

    public ResponseEntity<?> deleteEquipment(Long id) {
        Optional<Equipment> existsEquipment = equipmentRepository.findById(id);
        if (!existsEquipment.isPresent()) return ResponseEntity.status((HttpStatus.NOT_FOUND)).body("Equipment NOT FOUND," +
                "with ID: " + id);
        try {
            equipmentRepository.deleteById(id);
            return ResponseEntity.ok("Equipment deleted, with ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to delete equipment, with ID: " + id);
        }
    }
}
