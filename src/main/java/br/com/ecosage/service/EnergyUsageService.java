package br.com.ecosage.service;

import br.com.ecosage.model.EnergyUsage;
import br.com.ecosage.model.Equipment;
import br.com.ecosage.repository.EnergyUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class EnergyUsageService {

    @Autowired
    private EnergyUsageRepository energyUsageRepository;

    public ResponseEntity<?> energyUsageList() {
        try {
            List<EnergyUsage> energyUsages = energyUsageRepository.findAll();
            return ResponseEntity.ok(energyUsages);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }

    public ResponseEntity<?> createEnergyUsage(EnergyUsage energyUsage) {
        try {
            var totalDays = ChronoUnit.DAYS.between(energyUsage.getStartDate(), energyUsage.getEndDate());
            BigDecimal totalDaysBigDecimal = BigDecimal.valueOf(totalDays);
            var average = energyUsage.getTotalConsumedEnergy().divide(totalDaysBigDecimal, 2, RoundingMode.HALF_UP);
            energyUsage.setAverageDailyConsumption(average);
            EnergyUsage createdEnergyUsage = energyUsageRepository.save(energyUsage);
            return ResponseEntity.ok(createdEnergyUsage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error to create: " + e.getMessage());
        }
    }

    public ResponseEntity<?> getEnergyUsage(Long id) {
        Optional<EnergyUsage> energyUsage = energyUsageRepository.findById(id);
        if (!energyUsage.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Energy Usage NOT FOUND, with " +
                "ID: " + id);
        try {
            return ResponseEntity.ok(energyUsage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to get Energy Usage, with ID: " + id);
        }
    }

    public ResponseEntity<?> deleteEnergyUsage(Long id) {
        Optional<EnergyUsage> existsEnergyUsage = energyUsageRepository.findById(id);
        if (!existsEnergyUsage.isPresent()) return ResponseEntity.status((HttpStatus.NOT_FOUND)).body("Energy Usage NOT FOUND," +
                "with ID: " + id);
        try {
            energyUsageRepository.deleteById(id);
            return ResponseEntity.ok("Energy Usage deleted, with ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to delete Energy Usage, with ID: " + id);
        }
    }
}
