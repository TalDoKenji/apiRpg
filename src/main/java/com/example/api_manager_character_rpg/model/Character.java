package com.example.api_manager_character_rpg.model;

import com.example.api_manager_character_rpg.enums.Class;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity()
@Table(name = "table_character")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name_character")
    @NotNull()
    private String name;

    @Column(name = "name_summoner")
    @NotNull()
    private String nameSummoner;

    @Column(name = "class")
    @NotNull()
    private Class classCharacter;

    @Column(name = "level")
    @NotNull()
    @Min(value = 1)
    private Integer level;

    @Column(name = "atack")
    @NotNull()
    private Integer atackPoints;

    @Column(name = "defense")
    @NotNull()
    private Integer defensePoints;

}
