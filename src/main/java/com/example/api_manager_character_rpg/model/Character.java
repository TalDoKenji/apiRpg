package com.example.api_manager_character_rpg.model;

import com.example.api_manager_character_rpg.enums.Class;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "table_character")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = {"id"})
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_character")
    @NotNull()
    private String name;

    @Column(name = "name_summoner")
    @NotNull()
    private String nameSummoner;

    @Column(name = "class")
    @Enumerated(EnumType.STRING)
    @NotNull()
    private Class classCharacter;

    @Column(name = "level")
    @NotNull()
    @Min(value = 1)
    private Integer level;

    @Column(name = "attack")
    @NotNull()
    private Integer attackPoints;

    @Column(name = "defense")
    @NotNull()
    private Integer defensePoints;


    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("character")
    private List<Item> items = new ArrayList<>();


}
