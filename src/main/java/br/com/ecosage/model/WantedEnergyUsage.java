package br.com.ecosage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// TODO: CALCULAR O CONSUMO TOTAL BASEADO NOS EQUIPMENTS

@Entity
@Data
@Table(name = "wanted_energy_usage")
public class WantedEnergyUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalEnergy;

    private BigDecimal totalCost;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal averageDailyConsumption;

    @OneToMany(mappedBy = "wantedEnergyUsage", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("wantedEnergyUsage")
    private List<Equipment> equipments;
}
