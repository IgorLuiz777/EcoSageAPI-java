package br.com.ecosage.repository;

import br.com.ecosage.model.EnergyUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergyUsageRepository extends JpaRepository<EnergyUsage, Long> {
}
