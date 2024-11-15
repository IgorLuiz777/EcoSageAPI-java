package br.com.ecosage.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record WantedEnergyUsageRequest(
    BigDecimal totalEnergy,
    BigDecimal totalCost,
    LocalDate startDate,
    LocalDate endDate,
    BigDecimal averageDailyConsumption,
    List<Long> equipmentIds
) { }