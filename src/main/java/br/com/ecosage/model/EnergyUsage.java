package br.com.ecosage.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "energy_usage")
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
