package br.com.ecosage.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// TODO: CALCULAR O CONSUMO TOTAL BASEADO NOS EQUIPMENTS

@Entity
@Data
public class WantedEnergyUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalEnergy;

    private BigDecimal totalCost;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal averageDailyConsumption;

    @OneToMany
    @JoinColumn(name = "wantedEnergyUsage_id")
    private List<Equipment> equipments;
}
