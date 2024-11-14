package br.com.ecosage.controller;

import br.com.ecosage.model.EnergyUsage;
import br.com.ecosage.service.EnergyUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/energyUsage")
public class EnergyUsageController {

    @Autowired
    private EnergyUsageService energyUsageService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return energyUsageService.energyUsageList();
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody EnergyUsage energyUsage) {
        return energyUsageService.createEnergyUsage(energyUsage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return energyUsageService.getEnergyUsage(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return energyUsageService.deleteEnergyUsage(id);
    }
}
