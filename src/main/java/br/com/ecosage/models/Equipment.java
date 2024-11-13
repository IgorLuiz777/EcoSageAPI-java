package br.com.ecosage.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String power;

    private int avarageUsagePerDay;

    @ManyToOne
    private EquipmentCategory equipmentCategory;

    private String personalNote;

    // private User user;

    private boolean status;

}
