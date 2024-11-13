package br.com.ecosage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

// TODO: ADICONAR DTO - RESPONSE

@Entity
@Data
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private BigDecimal power;

    @NotNull
    private int averageUsagePerDay;

    @JsonIgnoreProperties("equipment")
    @ManyToOne
    @JoinColumn(name = "equipment_category_id")
    private EquipmentCategory equipmentCategory;

    private String personalNote;

    // private User user;

    private boolean status;

    public Equipment() {
        this.status = true;
    }
}
