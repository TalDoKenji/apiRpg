package com.example.api_manager_character_rpg.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateNameSummonerDTO {

    @NotNull
    private String nameSummoner;
}
