package com.example.api_manager_character_rpg.model;

import com.example.api_manager_character_rpg.enums.TypeItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "table_item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "type_item")
    @NotNull
    private TypeItem typeItem;

    @Column(name = "attack_points")
    @Max(value = 10)
    private Integer attackPoints;

    @Column(name = "defense_points")
    @Max(value = 10)
    private Integer defensePoints;

}
