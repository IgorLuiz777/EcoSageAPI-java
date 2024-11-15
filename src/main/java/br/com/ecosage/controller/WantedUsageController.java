package br.com.ecosage.controller;

import br.com.ecosage.model.dto.WantedEnergyUsageRequest;
import br.com.ecosage.service.WantedEnergyUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("energyWantedUsage")
public class WantedUsageController {

    @Autowired
    private WantedEnergyUsageService wantedEnergyUsageService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return wantedEnergyUsageService.listWantedEnergyUsage();
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody WantedEnergyUsageRequest wantedEnergyUsage) {
        return wantedEnergyUsageService.createWantedEnergyUsage(wantedEnergyUsage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return wantedEnergyUsageService.getWantedEnergyUsageById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody WantedEnergyUsageRequest wantedEnergyUsage) {
        return wantedEnergyUsageService.updateWantedEnergyUsage(id, wantedEnergyUsage);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return wantedEnergyUsageService.deleteWantedEnergyUsage(id);
    }
}
