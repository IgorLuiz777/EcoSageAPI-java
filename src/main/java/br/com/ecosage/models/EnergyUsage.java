package br.com.ecosage.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class EnergyUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalConsumedEnergy;

    private BigDecimal totalCost;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal averageDailyConsumption;
}
