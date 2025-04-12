package com.example.api_manager_character_rpg.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItemDTO {

    @NotNull()
    private Long id;
}
