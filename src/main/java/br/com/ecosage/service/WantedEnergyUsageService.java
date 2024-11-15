package br.com.ecosage.service;

import br.com.ecosage.model.Equipment;
import br.com.ecosage.model.WantedEnergyUsage;
import br.com.ecosage.model.dto.WantedEnergyUsageRequest;
import br.com.ecosage.repository.EquipmentRepository;
import br.com.ecosage.repository.WantedEnergyUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WantedEnergyUsageService {

    @Autowired
    private WantedEnergyUsageRepository wantedEnergyUsageRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    public ResponseEntity<?> listWantedEnergyUsage() {
        try {
            List<WantedEnergyUsage> list = wantedEnergyUsageRepository.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    public ResponseEntity<?> createWantedEnergyUsage(WantedEnergyUsageRequest wantedEnergyUsageRequest) {
        try {
            WantedEnergyUsage wantedEnergyUsage = new WantedEnergyUsage();
            wantedEnergyUsage.setTotalEnergy(wantedEnergyUsageRequest.totalEnergy());
            wantedEnergyUsage.setTotalCost(wantedEnergyUsageRequest.totalCost());
            wantedEnergyUsage.setStartDate(wantedEnergyUsageRequest.startDate());
            wantedEnergyUsage.setEndDate(wantedEnergyUsageRequest.endDate());
            wantedEnergyUsage.setAverageDailyConsumption(wantedEnergyUsageRequest.averageDailyConsumption());

            List<Equipment> equipments = new ArrayList<>();
            for (Long equipmentId : wantedEnergyUsageRequest.equipmentIds()) {
                Equipment equipment = equipmentRepository.findById(equipmentId)
                        .orElseThrow(() -> new IllegalArgumentException("Equipment not found with ID: " + equipmentId));
                equipments.add(equipment);
            }
            wantedEnergyUsage.setEquipments(equipments);

            WantedEnergyUsage savedEntity = wantedEnergyUsageRepository.save(wantedEnergyUsage);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error to create WantedEnergyUsage: " + e.getMessage());
        }
    }


    public ResponseEntity<?> getWantedEnergyUsageById(Long id) {
        Optional<WantedEnergyUsage> wantedEnergyUsage = wantedEnergyUsageRepository.findById(id);
        if (!wantedEnergyUsage.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        try {
             return ResponseEntity.ok().body(wantedEnergyUsage.get());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    public ResponseEntity<?> updateWantedEnergyUsage(Long id, WantedEnergyUsageRequest wantedEnergyUsageRequest) {
        Optional<WantedEnergyUsage> existingWantedEnergyUsage = wantedEnergyUsageRepository.findById(id);
        if (existingWantedEnergyUsage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wanted Usage not found with ID: " + id);
        }

        try {
            WantedEnergyUsage wantedEnergyUsage = existingWantedEnergyUsage.get();

            wantedEnergyUsage.setTotalEnergy(wantedEnergyUsageRequest.totalEnergy());
            wantedEnergyUsage.setTotalCost(wantedEnergyUsageRequest.totalCost());
            wantedEnergyUsage.setStartDate(wantedEnergyUsageRequest.startDate());
            wantedEnergyUsage.setEndDate(wantedEnergyUsageRequest.endDate());
            wantedEnergyUsage.setAverageDailyConsumption(wantedEnergyUsageRequest.averageDailyConsumption());

            wantedEnergyUsage.getEquipments().clear();

            for (Long equipmentId : wantedEnergyUsageRequest.equipmentIds()) {
                Equipment equipment = equipmentRepository.findById(equipmentId)
                        .orElseThrow(() -> new IllegalArgumentException("Equipment not found with ID: " + equipmentId));
                wantedEnergyUsage.getEquipments().add(equipment);
            }

            WantedEnergyUsage updatedEntity = wantedEnergyUsageRepository.save(wantedEnergyUsage);

            return ResponseEntity.ok(updatedEntity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error to update Wanted Usage: " + e.getMessage());
        }
    }


    public ResponseEntity<?> deleteWantedEnergyUsage(Long id) {
        Optional<WantedEnergyUsage> existsWantedEnergyUsage = wantedEnergyUsageRepository.findById(id);
        if (!existsWantedEnergyUsage.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        try {
            wantedEnergyUsageRepository.delete(existsWantedEnergyUsage.get());
            return ResponseEntity.ok("Deleted WantedEnergyUsage ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
