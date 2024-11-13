package br.com.ecosage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "equipment_category")
public class EquipmentCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnoreProperties("equipmentCategory")
    @OneToMany(mappedBy = "equipmentCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Equipment> equipments;

    @NotNull
    private String name;

    private String description;
}
