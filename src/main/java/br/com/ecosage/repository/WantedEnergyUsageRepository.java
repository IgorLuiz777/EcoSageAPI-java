package br.com.ecosage.repository;

import br.com.ecosage.model.WantedEnergyUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WantedEnergyUsageRepository extends JpaRepository<WantedEnergyUsage, Long> {
}
